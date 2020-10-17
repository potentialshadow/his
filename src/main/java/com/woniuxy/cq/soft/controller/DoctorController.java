package com.woniuxy.cq.soft.controller;

import java.util.Map;

import javax.annotation.Resource;

import com.woniuxy.cq.soft.entity.Employees;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.woniuxy.cq.soft.entity.Consultation;
import com.woniuxy.cq.soft.entity.PatDetail;
import com.woniuxy.cq.soft.service.DoctorService;
import com.woniuxy.cq.soft.util.JSONResult;


@RestController
@RequestMapping("doctor")
public class DoctorController {
	@Resource
	private DoctorService doctorSer;
	
	@RequestMapping("addadvice")
	public JSONResult	insertDoctorAdvice(@RequestBody	Map<String,Object> map) {
		doctorSer.insertDoctorAdvice(map);
		return new	JSONResult("200","新增医嘱成功",null,null);
	}
	
	@RequestMapping("selectadvice")
	public JSONResult selectDoctorAdvice(Integer pageNumber,Integer status) {
		return new JSONResult("200","查询成功",null,doctorSer.selectDoctorAdvice(pageNumber, status));
	}
	
	@DeleteMapping("{id}")
	public JSONResult deleteAdvice(@PathVariable("id")Integer id) {
		doctorSer.deleteAdvice(id);
		return new JSONResult("200","删除成功",null,null);
	}
	
	@RequestMapping("selectPatDetail")
	public JSONResult selectPatDetail(Integer pid,Integer pagenumber) {
		return new JSONResult("200","查询成功",null,doctorSer.selectPatDetail(pid, pagenumber));
	}
	
	@RequestMapping("selectMoneyDetail")
	public JSONResult selectMoneyDetail(Integer pid,Integer pagenumber) {
		return new JSONResult("200","查询成功",null,doctorSer.selectMoneyDetail(pid, pagenumber));
	}
	
	@RequestMapping("insertPatDetail")
	public JSONResult insertPatDetail(PatDetail patd) {
		System.out.println(patd);
		doctorSer.insertPatDetail(patd);
		return new JSONResult("200","新增成功",null,null);
	}
	
	/**
	 * 
		* @author 作者:jiejiang E-mail:1289687985@qq.com 
		* @version 创建时间：2020年10月15日 下午3:18:36 
		* 方法说明 :新增会诊情况
	 */
	@RequestMapping("insertConsultation")
	public JSONResult insertConsultation(Consultation	con) {
		Subject subject = SecurityUtils.getSubject();
		Employees employees= (Employees) subject.getPrincipal();
		con.setEid(employees.getId());
		doctorSer.insertConsultation(con);
		return new JSONResult("200","新增成功",null,null);
	}
	
	/**
	 * 
		* @author 作者:jiejiang E-mail:1289687985@qq.com 
		* @version 创建时间：2020年10月15日 下午3:56:53 
		* 方法说明 :查询该医生的所有会诊情况
	 */
	@RequestMapping("selectConsultation")
	public JSONResult selectConsultation(Integer pagenumber) {
		Subject subject = SecurityUtils.getSubject();
		Employees employees= (Employees) subject.getPrincipal();
		return new JSONResult("200","查询成功",null,doctorSer.selectConsultation(employees.getId(), pagenumber));
	}
	
	@RequestMapping("changePatientStatus")
	public JSONResult updatePatientStatus(Integer id,String patientStatus) {
		doctorSer.updatePatientStatus(id, patientStatus);
		return new JSONResult("200","添加成功",null,null);
	}
}
