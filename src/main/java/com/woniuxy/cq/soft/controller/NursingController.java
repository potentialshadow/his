package com.woniuxy.cq.soft.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.entity.Employees;
import com.woniuxy.cq.soft.entity.Nursing;
import com.woniuxy.cq.soft.entity.User;
import com.woniuxy.cq.soft.service.NursingService;
import com.woniuxy.cq.soft.util.JSONResult;

@RestController
@RequestMapping("nursing")
public class NursingController {
	@Resource
	private NursingService nursingService;
	@GetMapping
	public JSONResult selectNursings(int pageNum,int pageSize)throws Exception{
		Subject subject = SecurityUtils.getSubject();
		Employees employees= (Employees) subject.getPrincipal();
		return new JSONResult("200","success",null,nursingService.selectNursings(pageNum,pageSize,employees.getId()));
	}
	@PostMapping
	public JSONResult selectNursings(Nursing nursing)throws Exception{
		Subject subject = SecurityUtils.getSubject();
		Employees employees= (Employees) subject.getPrincipal();
		nursing.setEid(employees.getId());
		nursingService.insertNursing(nursing);
		return new JSONResult("200","success",null,null);
	}
	@DeleteMapping
	public JSONResult selectNursings(Integer id)throws Exception{
		nursingService.deleteNursing(id);
		return new JSONResult("200","success",null,null);
	}

}
