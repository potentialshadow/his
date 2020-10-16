package com.woniuxy.cq.soft.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.service.BedsService;
import com.woniuxy.cq.soft.util.JSONResult;

@RestController
@RequestMapping("beds")
public class BedsController {
	@Resource
	private BedsService bedsService;
	@GetMapping("{depid}")
	//查询该科室状态所有床位信息
	public JSONResult selectBeds(@PathVariable("depid")Integer depid)throws Exception{
		return new JSONResult("200","success",bedsService.selectBeds(depid),null);
		
	}
	@RequestMapping("selectDepart")
	public JSONResult selectBedsByDepartName(String depart)throws Exception{
		
		return new JSONResult("200","success",bedsService.selectBedsByDepartName(depart),null);
		
	}

}
