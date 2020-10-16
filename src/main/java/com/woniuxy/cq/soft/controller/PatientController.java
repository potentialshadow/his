package com.woniuxy.cq.soft.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.entity.Employees;
import com.woniuxy.cq.soft.entity.Patient;
import com.woniuxy.cq.soft.service.PatientService;
import com.woniuxy.cq.soft.util.JSONResult;

/**
 * @author Administrator
 * 病人表控制层
 */
@RestController
@RequestMapping("patient")
public class PatientController {
	@Resource
	private PatientService patientService;
	//新增病人表数据
	@PostMapping
	public JSONResult insertPatient(Patient patient)throws Exception{
		patient.setStatus("在院");
		patientService.insertPatient(patient);
		return new JSONResult("200","success",null,null);
	}
	//查询病人信息
	@GetMapping
	public JSONResult selectPatients(Integer pageNum,Integer pageSize)throws Exception{
		return new JSONResult("200","success",null,patientService.selectPatients(pageNum,pageSize));
		
	}
	//根据条件查询病人信息
	@RequestMapping("select")
	public JSONResult selectPatient(Integer pageNum,Integer pageSize,String name,String status)throws Exception{
	
		return new JSONResult("200","success",null,patientService.selectPatient(pageNum,pageSize,name,status));
		
	}
	//停止床位使用
	@RequestMapping("updateStatus")
	public JSONResult updatePatientsBeds(Integer id)throws Exception{
		patientService.updatePatientBeds(id);
		return new JSONResult("200","success",null,null);	
	}
	//病人设置床位
	@RequestMapping("updatePatientBeds")
	public JSONResult updatePatientBeds(Integer pid,String room)throws Exception{
		patientService.updatePatientBedsByname(pid, room);
		return new JSONResult("200","success",null,null);	
	}
	//查询在院病人
	@RequestMapping("selectPatientByStatus")
	public JSONResult selectPatientByStatus(Integer pageNum,Integer pageSize)throws Exception{
//		Subject subject = SecurityUtils.getSubject();
//		Employees employees= (Employees) subject.getPrincipal();
		return new JSONResult("200","success",null,patientService.selectPByStatus(pageNum, pageSize,"内科"));
		
	}
	//给病人指派医生，护士
	@RequestMapping("insertEmp")
	public JSONResult insertEmp(Integer id,Integer paid)throws Exception{
		patientService.insertEmp(id,paid);
		return new JSONResult("200","success",null,null);
		
	}
	//查询病人的医嘱
	@RequestMapping("selectMedical")
	public JSONResult selectMedical(Integer paid)throws Exception{
		
		return new JSONResult("200","success",patientService.selectMedical(paid),null);
		
	}
	//修改病人医嘱状态，改为执行
	@RequestMapping("updateMedical")
	public JSONResult updateMedical(Integer id,Integer paid)throws Exception{
		patientService.updateMedical(id,paid);
		return new JSONResult("200","success",null,null);
		
	}


}
