package com.woniuxy.cq.soft.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleService;
	@RequestMapping("selectRoles")
	public JSONResult selectRoles() throws Exception {
		return new JSONResult("200", "success", roleService.selectRoles(), null);
	}
}

