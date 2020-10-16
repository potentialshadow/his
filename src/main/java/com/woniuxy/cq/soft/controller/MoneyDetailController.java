package com.woniuxy.cq.soft.controller;

import javax.annotation.Resource;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.service.MoneyDetailService;
import com.woniuxy.cq.soft.util.JSONResult;

@RestController
@RequestMapping("moneyDetail")
public class MoneyDetailController {
	@Resource
	private MoneyDetailService moneyDetailService;
	@RequestMapping("selectMoneyDetail")
	public JSONResult selectMoneyDetailByPatid(Integer paid,int pageNum,int pageSize)throws Exception{
		return new JSONResult("200","success",null,moneyDetailService.selectMoneyDetail(paid,pageNum,pageSize));
	}
	@RequestMapping("selectById")
	public JSONResult selectMoneyDetail(Integer id)throws Exception{
		return new JSONResult("200","success",moneyDetailService.selectMoneyDetailByPaid(id),null);
	}

}
