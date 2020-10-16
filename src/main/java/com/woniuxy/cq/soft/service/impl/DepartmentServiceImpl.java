package com.woniuxy.cq.soft.service.impl;

import com.woniuxy.cq.soft.entity.Department;
import com.woniuxy.cq.soft.mapper.DepartmentMapper;
import com.woniuxy.cq.soft.service.DepartmentService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Resource
	private DepartmentMapper departmentMapper;
	@Override
	public List<Department> selectDepartments() throws Exception {
		return departmentMapper.selectByExample(null);
	}

}
