package com.woniuxy.cq.soft.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Nursing;
import com.woniuxy.cq.soft.mapper.NursingMapper;
import com.woniuxy.cq.soft.service.NursingService;
@Service
public class NursingServiceImpl implements NursingService{
	@Resource
	private NursingMapper nursingMapper;
	@Override
	public PageInfo<Map<String, Object>> selectNursings(int pageNum,int pageSize,Integer eid) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = nursingMapper.selectNursings(eid);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return pageInfo;
	}
	@Override
	public void insertNursing(Nursing nursing) throws Exception {
		nursingMapper.insertSelective(nursing);
	}
	@Override
	public void deleteNursing(Integer id) throws Exception {
		nursingMapper.deleteByPrimaryKey(id);
	}

}
