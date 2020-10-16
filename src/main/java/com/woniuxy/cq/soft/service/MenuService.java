package com.woniuxy.cq.soft.service;

import java.util.List;

import com.woniuxy.cq.soft.entity.Employees;
import com.woniuxy.cq.soft.entity.Menu;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
public interface MenuService {
	/**
	 * @Title: selectMenu
	 * @Description: TODO
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: List<Menu> 返回类型 
	 * @tags: 首页显示对应菜单
	 */
	public List<Menu> selectPermission(Employees employee) throws Exception;
	/**
	 * @Title: selectMenuByUid
	 * @Description: TODO
	 * @param: @param id
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: List<Menu> 返回类型 
	 * @tags: @param id
	 * @tags: 用户登录所见菜单
	 */
	public List<Menu> selectMenuByUid(Integer id) throws Exception;
	/**
	 * @Title: selectMenu
	 * @Description: TODO
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: List<Menu> 返回类型 
	 * @tags: 查询对应按钮
	 */
	public List<Menu> selectButton(Integer pid) throws Exception;
}
