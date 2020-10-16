package com.woniuxy.cq.soft.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.service.DepartService;
import com.woniuxy.cq.soft.util.JSONResult;

@RestController
@RequestMapping("depart")
public class DepartController {
	@Resource
	private DepartService departService;
	@GetMapping
	public JSONResult selectDepart()throws Exception{
		return new JSONResult("200","success",departService.selectDepart(),null);
		
	}

}
