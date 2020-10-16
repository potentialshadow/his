package com.woniuxy.cq.soft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniuxy.cq.soft.entity.Role;
import com.woniuxy.cq.soft.mapper.RoleMapper;
import com.woniuxy.cq.soft.service.RoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectRoles() throws Exception {
		return roleMapper.selectByExample(null);
	}

}
