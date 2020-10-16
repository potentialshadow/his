package com.woniuxy.cq.soft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Appointment;
import com.woniuxy.cq.soft.entity.AppointmentExample;
import com.woniuxy.cq.soft.mapper.AppointmentMapper;
import com.woniuxy.cq.soft.service.AppointmentService;

/**
 * @author Administrator
 * 预约信息业务层
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Resource
	private AppointmentMapper appointmentMapper;
	@Override
	//查询所有的预约通过的病人信息
	public PageInfo<Appointment> selectAppointments(int pageNum,int pageSize) throws Exception {
		AppointmentExample example = new AppointmentExample();
		//查询所有申请状态为通过的预约用户
		example.createCriteria().andStatusEqualTo(1);
		PageHelper.startPage(pageNum, pageSize);
		List<Appointment> list = appointmentMapper.selectByExample(example);
		PageInfo<Appointment> pageInfo = new PageInfo<Appointment>(list);
		return pageInfo;
	}
	@Override
	//根据主键查询预约用户
	public Appointment selectAppointmentById(Integer id) throws Exception {
		
		return appointmentMapper.selectByPrimaryKey(id);
	}

}
