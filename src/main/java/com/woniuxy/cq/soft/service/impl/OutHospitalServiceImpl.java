package com.woniuxy.cq.soft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniuxy.cq.soft.entity.OutHospital;
import com.woniuxy.cq.soft.entity.OutHospitalExample;
import com.woniuxy.cq.soft.mapper.OutHospitalMapper;
import com.woniuxy.cq.soft.service.OutHospitalService;
@Service
public class OutHospitalServiceImpl implements OutHospitalService {
	@Resource
	private OutHospitalMapper outHospitalMapper;

	@Override
	public void updateOutHospitalStatus(Integer paid,Integer status) throws Exception {
		OutHospitalExample example = new OutHospitalExample();
		example.createCriteria().andPaidEqualTo(paid);
		OutHospital outHospital = new OutHospital();
		outHospital.setStatus(status);
		outHospitalMapper.updateByExampleSelective(outHospital, example);
	}
	//根据病人id在出院申请表中查询出院申请病人
	@Override
	public OutHospital selectByPaid(Integer paid) throws Exception {
		OutHospitalExample example = new OutHospitalExample();
		example.createCriteria().andPaidEqualTo(paid);
		List<OutHospital> list = outHospitalMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	

}
