package com.woniuxy.cq.soft.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.entity.OutHospital;
import com.woniuxy.cq.soft.entity.Patient;
import com.woniuxy.cq.soft.entity.RefundDetails;
import com.woniuxy.cq.soft.service.Doctor2Service;
import com.woniuxy.cq.soft.util.JSONResult;

@RestController
@RequestMapping("doc2")
public class Doctor2Controller {
	@Resource
	private Doctor2Service doctor2Service;
	
	//动态查询在院病人
	@RequestMapping("query")
	public JSONResult queryPaMess(@RequestBody Map<String,Object> map) throws Exception{
		
		String name=(String) map.get("name");
		int	pageNum=(int) map.get("pageNum");
		int	pageSize=(int) map.get("pageSize");
		return new JSONResult("200","success",null,doctor2Service.queryPaMess(name,pageNum,pageSize));
	}
	//查询是否填写过申请
	@RequestMapping("queryMessById")
	public JSONResult queryMessById(Integer id) throws Exception{
		//Subject subject = SecurityUtils.getSubject();
				//User user = (User)subject.getPrincipal();
		
		
		return new JSONResult("200","success",null,doctor2Service.queryMessById(id));
	}
	//撤销申请
	@RequestMapping("deletd")
	public JSONResult deleteMessById(OutHospital out) throws Exception{
		System.out.println(out);
		doctor2Service.updateMessById(out);
		
		return new JSONResult("200","success",null,null);
	}
	//申请出院
	@RequestMapping("insertMessById")
	public JSONResult insertMessById(OutHospital out) throws Exception{
		//获取医生的id
		//Subject subject = SecurityUtils.getSubject();
		//Employees ee = (Employees)subject.getPrincipal();
		out.setEid(1);
		doctor2Service.insertMessById(out);
		return new JSONResult("200","success",null,null);
	}
	//新建入院记录
	@RequestMapping("insert")
	public JSONResult insert(@RequestBody Patient pa) throws Exception{
		
		doctor2Service.insertPaid(pa);
		return new JSONResult("200","success",null,null);
	}
	
	//退药申请
	@RequestMapping("outDrug")
	public JSONResult outDrug(@RequestBody RefundDetails re) throws Exception{
		
		doctor2Service.insertOutDrug(re);
		return new JSONResult("200","success",null,null);
	}
}
