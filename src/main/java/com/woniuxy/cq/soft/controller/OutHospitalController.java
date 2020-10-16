package com.woniuxy.cq.soft.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.service.OutHospitalService;
import com.woniuxy.cq.soft.util.JSONResult;

@RequestMapping("outhospital")
@RestController
public class OutHospitalController {
	@Resource
	private OutHospitalService outHospitalService;
	//修改出院审核病人状态
	@RequestMapping("updateOutHospitalStatus")
	public JSONResult updateHospitalStatus(Integer paid,Integer status)throws Exception{
		outHospitalService.updateOutHospitalStatus(paid,status);
		return new JSONResult("200","success",null,null);
	}
	//根据病人id查询病人
	@RequestMapping("selectByPaid")
	public JSONResult selectOutHospitalByPaid(Integer paid)throws Exception{
		
		return new JSONResult("200","success",null,outHospitalService.selectByPaid(paid));
		
	}
	
}
