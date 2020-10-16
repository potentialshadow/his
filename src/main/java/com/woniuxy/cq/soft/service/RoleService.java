package com.woniuxy.cq.soft.service;

import java.util.List;

import com.woniuxy.cq.soft.entity.Role;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
public interface RoleService {
	public List<Role> selectRoles() throws Exception;
}
