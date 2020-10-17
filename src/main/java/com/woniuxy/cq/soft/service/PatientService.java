package com.woniuxy.cq.soft.service;


import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Patient;

public interface PatientService {
	void insertPatient(Patient patient)throws Exception;
	PageInfo<Patient> selectPatients(Integer pageNum,Integer pageSize)throws Exception;
	void updatePatientBeds(Integer id)throws Exception;
	void updatePatientBedsByname(Integer pid,String room)throws Exception;
	PageInfo<Patient> selectPatient(Integer pageNum,Integer pageSize,String name,String status)throws Exception;
	PageInfo<Patient> selectPByStatus(Integer pageNum,Integer pageSize,Integer did)throws Exception;
	void insertEmp(Integer id,Integer paid)throws Exception;
	List<Map<String,Object>> selectMedical(Integer paid)throws Exception;
	void updateMedical(Integer id,Integer paid)throws Exception;
}
