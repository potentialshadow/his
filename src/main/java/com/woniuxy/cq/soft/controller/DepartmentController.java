package com.woniuxy.cq.soft.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.service.DepartmentService;
import com.woniuxy.cq.soft.util.JSONResult;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Resource
	private DepartmentService departmentService;
	@RequestMapping("selectDepartments")
	public JSONResult selectDepartments() throws Exception{
		return new JSONResult("200", "success", departmentService.selectDepartments(), null);
	}
}

