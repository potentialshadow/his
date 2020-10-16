package com.woniuxy.cq.soft.controller;


import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.entity.Employees;
import com.woniuxy.cq.soft.service.MenuService;
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
@RequestMapping("/menu")
public class MenuController {
	@Resource
	private MenuService menuService;

	/**
	 * @Title: selectMenu
	 * @Description: TODO
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: @return
	 * @tags: 对应权限
	 */
	@RequestMapping("menu")
	public JSONResult selectMenu() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		Employees employee=(Employees) subject.getPrincipal();
		return new JSONResult("200", "success", menuService.selectPermission(employee), null);
	}
	/**
	 * @Title: selectMenuByUid
	 * @Description: TODO
	 * @param: @param id
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: @param id
	 * @tags: 用户登录所见菜单
	 */
	@RequestMapping("user")
	public JSONResult selectMenuByUid(Integer uid)throws Exception{
		return new JSONResult("200", "success", menuService.selectMenuByUid(uid), null);
	}
	/**
	 * @Title: selectButton
	 * @Description: TODO
	 * @param: @param did
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: @param did
	 * @tags: 查询该权限下的所有按钮
	 */
	@RequestMapping("button")
	public JSONResult selectButton(Integer pid) throws Exception{
		return new JSONResult("200","success",menuService.selectButton(pid),null);
	}
}

