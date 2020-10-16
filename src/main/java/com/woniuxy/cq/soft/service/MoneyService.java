package com.woniuxy.cq.soft.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Appointment;
import com.woniuxy.cq.soft.entity.MoneyDetail;
import com.woniuxy.cq.soft.entity.Patient;

public interface MoneyService {
	public void insertMoney(Patient pat);
	
	public Map<String,Object>	selectByCardId(Integer cardId,Integer	pageNumber);
	
	public	Map<String,Object>	selectByTime(Integer cardId,Integer	pagenumber);
	
	public Map<String,Object>	selectByStatus(Integer pid,Integer	status,Integer	pagenumber);
	
	public PageInfo<Patient>	selectPatientByStatus(String status,Integer pagenumber);
	
	public void	updateMoneyByPatid(Integer pid,Double money);
	
	public void updateAppoStatus(Integer id,Integer status);
	
	public PageInfo<Appointment> selectAppos(Integer pageNum,Integer pageSize);
}
