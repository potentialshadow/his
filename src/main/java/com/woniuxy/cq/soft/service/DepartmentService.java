package com.woniuxy.cq.soft.service;

import java.util.List;

import com.woniuxy.cq.soft.entity.Department;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
public interface DepartmentService {
	public List<Department> selectDepartments() throws Exception;
}
