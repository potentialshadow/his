package com.woniuxy.cq.soft.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.woniuxy.cq.soft.entity.Employees;
import com.woniuxy.cq.soft.entity.Menu;
import com.woniuxy.cq.soft.service.EmployeesService;
import com.woniuxy.cq.soft.service.MenuService;

public class EmployeeRealm extends AuthorizingRealm{
	@Resource
	private EmployeesService employeesService;
	@Resource
	private MenuService menuService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Employees employee=(Employees)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		try {
			List<Menu> permissions = menuService.selectPermission(employee);
			for (Menu menu : permissions) {
				simpleAuthorizationInfo.addStringPermission(menu.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String phone=(String)token.getPrincipal();
		SimpleAuthenticationInfo authenticationInfo=null;
		try {
			Employees employees=(Employees) employeesService.selectByPhone(phone);
			authenticationInfo = new SimpleAuthenticationInfo(employees,employees.getPassword(),getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authenticationInfo;
	}

}
