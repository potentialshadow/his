package com.woniuxy.cq.soft.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Consultation;
import com.woniuxy.cq.soft.entity.MoneyDetail;
import com.woniuxy.cq.soft.entity.PatDetail;
import com.woniuxy.cq.soft.entity.DoctorAdviceDetails;

public interface DoctorService {
	public void	insertDoctorAdvice(Map<String,Object>	map);
	
	public PageInfo<DoctorAdviceDetails> selectDoctorAdvice(Integer pagenumber,Integer status);
	
	public void deleteAdvice(Integer id);
	
	public PageInfo<PatDetail> selectPatDetail(Integer id,Integer pagenumber);
	
	public PageInfo<MoneyDetail>	selectMoneyDetail(Integer id,Integer pagenumber);
	
	public void insertPatDetail(PatDetail patd);
	
	public void insertConsultation(Consultation	con);
	
	public PageInfo<Consultation>	selectConsultation(Integer eid,Integer pagenumber);
	
	public void updatePatientStatus(Integer id,String patientStatus);
}
