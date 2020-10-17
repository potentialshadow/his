package com.woniuxy.cq.soft.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.entity.Drug;
import com.woniuxy.cq.soft.entity.DrugRecords;
import com.woniuxy.cq.soft.entity.RefundDetails;
import com.woniuxy.cq.soft.service.DrugService;
import com.woniuxy.cq.soft.util.JSONResult;

//药房人员功能
@RestController
@RequestMapping("drug")
public class DrugController {
	@Resource
	private DrugService drugService;
	
	//查询医嘱
	@RequestMapping("soushuo")
	public JSONResult query(@RequestBody Map<String,Object> map) throws Exception{
		String name=(String) map.get("name");
		String item=(String) map.get("item");
		int	pageNum=(int) map.get("pageNum");
		int	pageSize=(int) map.get("pageSize");
		
		return new JSONResult("200","success",null,drugService.query(name,item,pageNum,pageSize));
	}
	//根据药品名字查询库存数量
	@RequestMapping("queryNum")
	public JSONResult queryNum(String name) throws Exception{
		
		return new JSONResult("200","success",null,drugService.queryNum(name));
	}
	
	//根据药品名字查询库存数量
	@RequestMapping("insertRecord")
	public JSONResult insertRecord(DrugRecords drug) throws Exception{
		
		drugService.insertRecord(drug);
		
		return new JSONResult("200","success",null,null);
	}
	
	//动态查询药品出库记录
	@RequestMapping("record")
	public JSONResult queryRecord(@RequestBody Map<String,Object> map) throws Exception{
		
		String name=(String) map.get("name");
		String paname=(String) map.get("paname");
		int	pageNum=(int) map.get("pageNum");
		int	pageSize=(int) map.get("pageSize");
		
		return new JSONResult("200","success",null,drugService.queryRecord(name,paname,pageNum,pageSize));
	}
	//动态查询药品信息
	@RequestMapping("queryMess")
	public JSONResult queryMess(@RequestBody Map<String,Object> map) throws Exception{
		
		String name=(String) map.get("name");
		int	pageNum=(int) map.get("pageNum");
		int	pageSize=(int) map.get("pageSize");
		
		return new JSONResult("200","success",null,drugService.queryMess(name,pageNum,pageSize));
	}
	
	//根据药品ID查询药品信息
	@RequestMapping("queryMessById")
	public JSONResult queryMessById(Integer id) throws Exception{
		
		return new JSONResult("200","success",null,drugService.queryMessById(id));
	}
	//更新药品信息
	@RequestMapping("updataMessById")
	public JSONResult updataMessById(Drug dr) throws Exception{
		drugService.updateMessById(dr);
		return new JSONResult("200","success",null,null);
	}
	//根据id删除
	@RequestMapping("deleteMessById")
	public JSONResult deleteMessById(Integer id) throws Exception{
		drugService.deleteMessById(id);
		return new JSONResult("200","success",null,null);
	}
	
	//新增药品
	@RequestMapping("insertMess")
	public JSONResult insertMess(Drug de) throws Exception{
		
		drugService.insertMess(de);
		return new JSONResult("200","success",null,null);
	}
	//查询申请退药
	@RequestMapping("qureryReturnMess")
	public JSONResult qureryReturnMess(@RequestBody Map<String,Object> map) throws Exception{
		
		String name=(String) map.get("name");
		int	pageNum=(int) map.get("pageNum");
		int	pageSize=(int) map.get("pageSize");
		
		return new JSONResult("200","success",null,drugService.qureryReturnMess(name,pageNum,pageSize));
	}
	//申请退药通过
	@RequestMapping("updataRuterunMess")
	public JSONResult updateRuterunMess(@RequestBody RefundDetails re) throws Exception{
		drugService.updateRuterunMess(re);
		return new JSONResult("200","success",null,null);
	}
	//护士查询退药申请
	@RequestMapping("nursQureryMess")
	public JSONResult nursQureryMess(@RequestBody Map<String,Object> map) throws Exception{
		
		String name=(String) map.get("name");
		int	pageNum=(int) map.get("pageNum");
		int	pageSize=(int) map.get("pageSize");
		
		return new JSONResult("200","success",null,drugService.nursQureryMess(name,pageNum,pageSize));
	}
	
	//护士退药审批和退回
	@RequestMapping("nruUpdataRuterunMess")
	public JSONResult nruUpdataRuterunMess(@RequestBody RefundDetails re) throws Exception{
		System.out.println(re);
		drugService.updateNruRuterunMess(re);
		
		return new JSONResult("200","success",null,null);
	}
}
