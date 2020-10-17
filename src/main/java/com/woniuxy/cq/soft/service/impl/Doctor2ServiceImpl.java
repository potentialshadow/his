package com.woniuxy.cq.soft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.DoctorAdviceDetails;
import com.woniuxy.cq.soft.entity.DoctorAdviceDetailsExample;
import com.woniuxy.cq.soft.entity.DrugRecords;
import com.woniuxy.cq.soft.entity.OutHospital;
import com.woniuxy.cq.soft.entity.OutHospitalExample;
import com.woniuxy.cq.soft.entity.Patient;
import com.woniuxy.cq.soft.entity.PatientExample;
import com.woniuxy.cq.soft.entity.RefundDetails;
import com.woniuxy.cq.soft.mapper.DoctorAdviceDetailsMapper;
import com.woniuxy.cq.soft.mapper.OutHospitalMapper;
import com.woniuxy.cq.soft.mapper.PatientMapper;
import com.woniuxy.cq.soft.mapper.RefundDetailsMapper;
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
	//动态查询在院病人
	@Override
	public Object queryPaMess(String name, int pageNum, int pageSize) throws Exception{
		PatientExample example = new PatientExample();
		example.createCriteria().andNameLike("%"+name+"%").andStatusEqualTo("0");
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