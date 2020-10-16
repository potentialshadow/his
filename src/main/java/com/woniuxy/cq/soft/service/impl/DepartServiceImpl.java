package com.woniuxy.cq.soft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniuxy.cq.soft.entity.Department;
import com.woniuxy.cq.soft.mapper.DepartmentMapper;
import com.woniuxy.cq.soft.service.DepartService;
@Service
public class DepartServiceImpl implements DepartService {
	@Resource
	private DepartmentMapper departmentMapper;

	@Override
	public List<Department> selectDepart() throws Exception {
		
		return departmentMapper.selectByExample(null);
	}
	

}
