package com.woniuxy.cq.soft.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.service.AppointmentService;
import com.woniuxy.cq.soft.util.JSONResult;

/**
 * @author Administrator
 * 预约信息表控制层
 */
@RestController
@RequestMapping("appointment")
public class AppointmentController {
	@Resource
	private AppointmentService appointmentService;
	//查询所有的预约通过的病人信息
	@GetMapping
	public JSONResult selectAppointments(int pageNum,int pageSize)throws Exception{
		return new JSONResult("200","success",null,appointmentService.selectAppointments(pageNum,pageSize));
	}
	//根据id查询预约信息
	@RequestMapping("selectAppoById")
	public JSONResult selectAppointmentById(Integer id)throws Exception{
		return new JSONResult("200","success",null,appointmentService.selectAppointmentById(id));
	}
	

}
