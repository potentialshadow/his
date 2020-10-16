package com.woniuxy.cq.soft.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.MoneyDetail;
import com.woniuxy.cq.soft.entity.MoneyDetailExample;
import com.woniuxy.cq.soft.mapper.MoneyDetailMapper;
import com.woniuxy.cq.soft.mapper.OutHospitalMapper;
import com.woniuxy.cq.soft.service.MoneyDetailService;
@Service
public class MoneyDetailServiceImpl implements MoneyDetailService{
	@Resource
	private MoneyDetailMapper moneyDetailMapper;
	@Resource
	private OutHospitalMapper outHospitalMapper;
	@Override
	public PageInfo<Map<String, Object>> selectMoneyDetail(Integer paid,int pageNum,int pageSize) throws Exception {
			PageHelper.startPage(pageNum, pageSize);
			List<Map<String, Object>> list = moneyDetailMapper.selectOutMonry(paid);
			PageInfo<Map<String, Object>> pageInfo=null;
			if(list.size()>0&&list!=null) {
				pageInfo = new PageInfo<Map<String, Object>>(list);
			}
			return pageInfo;
	}
	@Override
	public List<MoneyDetail> selectMoneyDetailByPaid(Integer paid) throws Exception {
		MoneyDetailExample example = new MoneyDetailExample();
		example.createCriteria().andPatidEqualTo(paid);
		return moneyDetailMapper.selectByExample(example);
	}

}
