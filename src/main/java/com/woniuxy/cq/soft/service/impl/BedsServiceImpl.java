package com.woniuxy.cq.soft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniuxy.cq.soft.entity.Beds;
import com.woniuxy.cq.soft.entity.BedsExample;
import com.woniuxy.cq.soft.mapper.BedsMapper;
import com.woniuxy.cq.soft.service.BedsService;
@Service
public class BedsServiceImpl implements BedsService {
	@Resource
	private BedsMapper bedsMapper;

	@Override
	//查询该科室的所有床位信息
	public List<Beds> selectBeds(Integer depid) throws Exception {
		BedsExample example = new BedsExample();
		example.createCriteria().andDepidEqualTo(depid);
		return bedsMapper.selectByExample(example);
	}
	//根据科室名称去查询科室id,在查询对应科室状态为0的床位
	@Override
	public List<Beds> selectBedsByDepartName(String name) throws Exception {
		
		return bedsMapper.selectDepartByName(name);
	}
	

}
