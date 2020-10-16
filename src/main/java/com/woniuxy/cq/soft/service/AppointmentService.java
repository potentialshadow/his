package com.woniuxy.cq.soft.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Appointment;

public interface AppointmentService {
	PageInfo<Appointment> selectAppointments(int pageNum,int pageSize)throws Exception;
	Appointment selectAppointmentById(Integer id)throws Exception;
}
