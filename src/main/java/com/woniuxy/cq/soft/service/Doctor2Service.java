package com.woniuxy.cq.soft.service;

import java.util.List;

import com.woniuxy.cq.soft.entity.OutHospital;
import com.woniuxy.cq.soft.entity.Patient;
import com.woniuxy.cq.soft.entity.RefundDetails;

public interface Doctor2Service {

	Object queryPaMess(String name, int pageNum, int pageSize) throws Exception;

	Object queryMessById(Integer id) throws Exception;

	void updateMessById(OutHospital out) throws Exception;

	void insertMessById(OutHospital out);

	void insertPaid(Patient pa);

	void insertOutDrug(RefundDetails re);
	
	

}
