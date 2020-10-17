package com.woniuxy.cq.soft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.woniuxy.cq.soft.entity.*;
import com.woniuxy.cq.soft.mapper.*;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.service.Doctor2Service;
@Service
public class Doctor2ServiceImpl implements Doctor2Service{
	@Resource
	private PatientMapper patientMapper;
	@Resource
	private OutHospitalMapper outHospitalMapper;
	@Resource
	private RefundDetailsMapper refundDetailsMapper;
	@Resource
	private  DoctorAdviceDetailsMapper  doctorAdviceDetailsMapper;
	@Resource
	private BedsMapper bedsMapper;
	@Resource
	private DepartmentMapper departmentMapper;
	//动态查询在院病人
	@Override
	public Object queryPaMess(String name, int pageNum, int pageSize) throws Exception{
		PatientExample example = new PatientExample();
		example.createCriteria().andNameLike("%"+name+"%").andStatusEqualTo("在院");
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<Patient> list = patientMapper.selectByExample(example);
		PageInfo<Patient> pageInfo=new PageInfo<Patient>(list);
		
		return pageInfo;
	}
	//查询是否填写过申请
	@Override
	public Object queryMessById(Integer id) throws Exception{
		OutHospitalExample example = new OutHospitalExample();
		//0是提交，1是审核，2是不通过
		example.createCriteria().andPaidEqualTo(id).andStatusEqualTo(0);
		
		List<OutHospital> list = outHospitalMapper.selectByExample(example);
		if(list.get(0)!= null && list.size()>0) {
			return list.get(0);
		}else {
			return null;	
		}
	}
	//撤销申请
	@Override
	public void updateMessById(OutHospital out) throws Exception {
		
		out.setStatus(2);
		outHospitalMapper.updateByPrimaryKey(out);
	}
	//申请出院
	@Override
	public void insertMessById(OutHospital out) {
		outHospitalMapper.insertSelective(out);
		
	}
	//新建入院记录
	@Override
	public void insertPaid(Patient pa) {
		pa.setStatus("在院");

		BedsExample bedsExample=new BedsExample();
		bedsExample.createCriteria().andRoomEqualTo(pa.getBeds());
		List<Beds> list=  bedsMapper.selectByExample(bedsExample);
		Beds b1=list.get(0);
		b1.setStatus(1);
		bedsMapper.updateByPrimaryKey(b1);
		//pa的id是部门id
		Department de=departmentMapper.selectByPrimaryKey(pa.getId());
		System.out.println(de);
		pa.setDepartment(de.getName());
		pa.setId(null);
		patientMapper.insertSelective(pa);
	}
	//新增退药申请
	@Override
	public void insertOutDrug(RefundDetails re) {
		
		DoctorAdviceDetails details = new DoctorAdviceDetails();
		details.setId(re.getDdid());
		details.setStatus("0");
		doctorAdviceDetailsMapper.updateByPrimaryKeySelective(details);
		System.out.println(re);
		re.setStatus("1");
		refundDetailsMapper.insertSelective(re);
	}
}
