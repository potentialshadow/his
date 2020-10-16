package com.woniuxy.cq.soft.service;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Employees;
import com.woniuxy.cq.soft.entity.EmployeesVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
public interface EmployeesService {
	/**
	 * @Title: selectByUsername
	 * @Description: TODO
	 * @param: @param username
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: Employees 返回类型 
	 * @tags: @param username
	 * @tags: 登录权限
	 */
	public Employees selectByPhone(String phone) throws Exception;
	/**
	 * @Title: selectEmployees
	 * @Description: TODO
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: List<Employees> 返回类型 
	 * @tags: 查询所有员工
	 */
	public PageInfo<EmployeesVO> selectEmployees(String context,EmployeesVO employeesVO) throws Exception;
	/**
	 * @Title: insertEmployee
	 * @Description: TODO
	 * @param: @param employee
	 * @param: @throws Exception 参数 
	 * @return: void 返回类型 
	 * @tags: @param employee
	 * @tags: 新增用户
	 */
	public void insertEmployee(Employees employee) throws Exception;
	/**
	 * @Title: selectEmployeeById
	 * @Description: TODO
	 * @param: @param id
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: Employees 返回类型 
	 * @tags: @param id
	 * @tags: 根据id查询员工信息
	 */
	public Employees selectEmployeeById(Integer id) throws Exception;
	/**
	 * @Title: updateEmployee
	 * @Description: TODO
	 * @param: @param employee
	 * @param: @throws Exception 参数 
	 * @return: void 返回类型 
	 * @tags: @param employee
	 * @tags: 更新员工信息
	 */
	public void updateEmployee(Employees employee) throws Exception;
	/**
	 * @Title: deleteEmployee
	 * @Description: TODO
	 * @param: @param id
	 * @param: @throws Exception 参数 
	 * @return: void 返回类型 
	 * @tags: @param id
	 * @tags: 根据id更新员工状态
	 */
	public void deleteEmployee(Employees employees) throws Exception;
	public List<Employees> selectDocById(Integer id)throws Exception;
	public List<Employees> selectNurById(Integer id)throws Exception;
}
