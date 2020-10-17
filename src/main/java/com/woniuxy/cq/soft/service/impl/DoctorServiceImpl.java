package com.woniuxy.cq.soft.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.woniuxy.cq.soft.entity.*;
import com.woniuxy.cq.soft.mapper.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.PatDetailExample.Criteria;
import com.woniuxy.cq.soft.service.DoctorService;

@Service
public class DoctorServiceImpl implements	DoctorService{
	@Resource
	private DoctorAdviceMapper	doctorad;
	@Resource
	private DoctorAdviceDetailsMapper	doctoradDe;
	@Resource
	private PatDetailMapper 	pat;
	@Resource
	private MoneyDetailMapper MD;
	@Resource
	private ConsultationMapper conMapper;
	@Resource
	private DrugMapper	drugMapper;
	@Override
	//新增医嘱
	public void insertDoctorAdvice(Map<String, Object> map) {
		//新增医嘱
		DoctorAdvice advice = new DoctorAdvice();
		advice.setPaid(Integer.parseInt(map.get("pid")+""));
		Subject subject = SecurityUtils.getSubject();
		Employees employees= (Employees) subject.getPrincipal();
		advice.setEid(employees.getId());
		advice.setStatus(0+"");
		doctorad.insert(advice);
		int did=advice.getId();
		advice=null;
		//新增医嘱详情
		List<DoctorAdviceDetails> list=(List<DoctorAdviceDetails>)map.get("detail");
		for(int i = 0;i<list.size();i++){
			DoctorAdviceDetails doct = JSON.parseObject(JSON.toJSONString(list.get(i)),DoctorAdviceDetails.class);
			//判断类型是药品还是护理或者手术
			if(doct.getType().equals("药品")) {
				//查询药品单价
				DrugExample	example=new	DrugExample();
				
				DrugExample.Criteria criteria = example.createCriteria();
				criteria.andDrugNameEqualTo(doct.getDrugName());
				List<Drug> list2 = drugMapper.selectByExample(example);
				doct.setPrice(list2.get(0).getPrice());
			}
			doct.setDid(did);
			list.set(i, doct);
		}
		doctoradDe.insertAdvices(list);
	}
	
	//查询该医生的所有医嘱
	@Override
	public PageInfo<DoctorAdviceDetails> selectDoctorAdvice(Integer pagenumber,Integer status) {
		PageHelper.startPage(pagenumber, 10);
		//获得登陆医生id
		Subject subject = SecurityUtils.getSubject();
		Employees employees= (Employees) subject.getPrincipal();
		List<DoctorAdviceDetails> list = doctoradDe.selectDoctorAdvice(employees.getId(), status);
		PageInfo<DoctorAdviceDetails> pageinfo=new PageInfo<DoctorAdviceDetails>(list);
		return pageinfo;
	}

	//删除单个医嘱
	@Override
	public void deleteAdvice(Integer id) {
		doctoradDe.deleteByPrimaryKey(id);
	}
	
	//查询医嘱详情
	@Override
	public PageInfo<PatDetail> selectPatDetail(Integer id, Integer pagenumber) {
		PageHelper.startPage(pagenumber, 10);
		PatDetailExample example = new	PatDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<PatDetail> list = pat.selectByExample(example);
		PageInfo<PatDetail> pageinfo=new PageInfo<PatDetail>(list);
		return pageinfo;
	}

	//查询费用详情
	@Override
	public PageInfo<MoneyDetail> selectMoneyDetail(Integer id, Integer pagenumber) {
		PageHelper.startPage(pagenumber, 10);
		MoneyDetailExample example = new	MoneyDetailExample();
		MoneyDetailExample.Criteria criteria = example.createCriteria();
		criteria.andPatidEqualTo(id);
		List<MoneyDetail> list = MD.selectByExample(example);
		PageInfo<MoneyDetail> pageinfo=new PageInfo<MoneyDetail>(list);
		return pageinfo;
	}

	//新增单条病历
	@Override
	public void insertPatDetail(PatDetail patd) {
		Subject subject = SecurityUtils.getSubject();
		Employees employees= (Employees) subject.getPrincipal();
		patd.setEid(employees.getId());
		patd.seteName(employees.getName());
		System.out.println(employees.toString());
		System.out.println(patd);
		pat.insertSelective(patd);
	}

	@Override
	public void insertConsultation(Consultation consult) {
		/** 
		* @author 作者:jiejiang E-mail:1289687985@qq.com: 
		* @version 创建时间：2020年10月15日 下午3:23:14 
		* 方法说明 :创建会诊信息
		*/ 
		conMapper.insertSelective(consult);
	}

	@Override
	public PageInfo<Consultation> selectConsultation(Integer eid,Integer pagenumber) {
		/** 
		* @author 作者:jiejiang E-mail:1289687985@qq.com: 
		* @version 创建时间：2020年10月15日 下午4:01:42 
		* 方法说明 :获得该医生所有的会诊信息
		*/
		ConsultationExample example = new ConsultationExample();
		ConsultationExample.Criteria criteria = example.createCriteria();
		criteria.andEidEqualTo(eid);
		PageHelper.startPage(pagenumber, 10);
		List<Consultation> list = conMapper.selectByExample(example);
		return new PageInfo<Consultation>(list);
	}


	@Override
	public void updatePatientStatus(Integer id, String patientStatus) {
		/** 
		* @author 作者:jiejiang E-mail:1289687985@qq.com: 
		* @version 创建时间：2020年10月15日 下午5:05:24 
		* 方法说明 :录入会诊记录
		*/ 
		Consultation record = new Consultation();

		record.setId(id);
		record.setPatientStatus(patientStatus);
		conMapper.updateByPrimaryKeySelective(record);
	}
	
}
