package com.woniuxy.cq.soft.service;

import com.woniuxy.cq.soft.entity.OutHospital;

public interface OutHospitalService {
	void updateOutHospitalStatus(Integer paid,Integer status)throws Exception;
	OutHospital selectByPaid(Integer paid)throws Exception;
}
