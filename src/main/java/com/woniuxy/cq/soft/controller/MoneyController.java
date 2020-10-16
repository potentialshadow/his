package com.woniuxy.cq.soft.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.entity.MoneyDetail;
import com.woniuxy.cq.soft.entity.Patient;
import com.woniuxy.cq.soft.service.MoneyService;
import com.woniuxy.cq.soft.util.JSONResult;

@RestController
@RequestMapping("money")
public class MoneyController {
	@Resource
	private MoneyService	service;
	//入院缴费
	@PostMapping
	public JSONResult	insertMoney(Patient pat) {
		service.insertMoney(pat);
		return new JSONResult("200","缴费成功",null,null);
	}
	
	//查询待通过入院申请
	@RequestMapping("selectAppos")
	public JSONResult	selectAppos(Integer pageNum,Integer pageSize) {
		return new JSONResult("200","操作成功",null,service.selectAppos(pageNum, pageSize));
	} 
	
	//通过入院申请
	@RequestMapping("changeAppoStatus")
	public JSONResult	updateAppoStatus(Integer id,Integer status) {
		service.updateAppoStatus(id, status);
		return new JSONResult("200","操作成功",null,null);
	}
	@RequestMapping("page")
	public JSONResult	selectMoney(Integer cardId,Integer	pagenumber) {
		return new JSONResult("200","success",null,service.selectByCardId(cardId,pagenumber));
	}
	
	@RequestMapping("time")
	public JSONResult	selectMoneyByTime(Integer cardId,Integer	pagenumber) {
		return new JSONResult("200","success",null,service.selectByTime(cardId,pagenumber));
	}
	
	@RequestMapping("status")
	public JSONResult	selectMoneyByStatus(Integer pid,Integer	status,Integer	pagenumber) {
		System.out.println(pid+""+status+pagenumber);
		return new JSONResult("200","success",null,service.selectByStatus(pid,status,pagenumber));
	}
	
	@RequestMapping("patientstatus")
	public JSONResult	selectPatientByStatus(String status,Integer pagenumber) {
		return new JSONResult("200","success",null,service.selectPatientByStatus(status,pagenumber));
	}
	
	@RequestMapping("state")
	public JSONResult	selectPatientByStatus(Integer pid,Double money) {
		service.updateMoneyByPatid(pid,money);
		return new JSONResult("200","结算成功",null,null);
	}
	
	
}
