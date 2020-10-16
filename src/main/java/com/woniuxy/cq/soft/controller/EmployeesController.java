package com.woniuxy.cq.soft.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.entity.Employees;
import com.woniuxy.cq.soft.entity.EmployeesVO;
import com.woniuxy.cq.soft.service.EmployeesService;
import com.woniuxy.cq.soft.util.JSONResult;
import com.woniuxy.cq.soft.util.MD5Utils;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/employees")
public class EmployeesController {
	@Resource
	private EmployeesService employeesService;
	@RequestMapping("login")
	public JSONResult selectByUserName(Employees employee,boolean rememberMe)throws Exception{
		String password = employee.getPassword();
		password=MD5Utils.MD5EncodeUtf8(password);
		employee.setPassword(password);
		UsernamePasswordToken token = new UsernamePasswordToken(employee.getPhone(), employee.getPassword(),rememberMe);
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()&&!subject.isRemembered()) {
			subject.login(token);
		}
		return new JSONResult("200", "success", null, employeesService.selectByPhone(employee.getPhone()));
	}
	/**
	 * @Title: selectEmployees
	 * @Description: TODO
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: 动态条件分页查询所有员工
	 */
	@RequestMapping("selectEmployees")
	public JSONResult selectEmployees(@RequestBody Map<String,Object> map) throws Exception{
		EmployeesVO employeesVO = new EmployeesVO();
		employeesVO.setPage((Integer) map.get("page"));
		employeesVO.setNum((Integer) map.get("num"));
		Integer status=(Integer) map.get("status");
		employeesVO.setStatus(status);
		return new JSONResult("200", "success", null, employeesService.selectEmployees((String) map.get("context"),employeesVO));
	}
	/**
	 * @Title: insertEmployee
	 * @Description: TODO
	 * @param: @param employee
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: @param employee
	 * @tags: 新增员工
	 */
	@RequestMapping("insertEmployee")
	public JSONResult insertEmployee(Employees employee) throws Exception{
		String password = employee.getPassword();
		password=MD5Utils.MD5EncodeUtf8(password);
		employee.setPassword(password);
		employeesService.insertEmployee(employee);
		return new JSONResult("200", "success", null, null);
	}
	/**
	 * @Title: selectEmployeeById
	 * @Description: TODO
	 * @param: @param id
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: @param id
	 * @tags: 根据id查出员工信息
	 */
	@GetMapping("{id}")
	public JSONResult selectEmployeeById(@PathVariable("id") Integer id) throws Exception{
		return new JSONResult("200", "success", null, employeesService.selectEmployeeById(id));
	}
	/**
	 * @Title: updateEmployee
	 * @Description: TODO
	 * @param: @param id
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: @param id
	 * @tags: 更新员工信息
	 */
	@RequestMapping("updateEmployee")
	public JSONResult updateEmployee(Employees employee) throws Exception{
		employeesService.updateEmployee(employee);
		return new JSONResult("200", "success", null, null);
	}
	/**
	 * @Title: deleteEmployee
	 * @Description: TODO
	 * @param: @param id
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: @param id
	 * @tags: 根据id改变员工状态
	 */
	@RequestMapping("deleteEmployee")
	public JSONResult deleteEmployee(Integer id) throws Exception{
		Employees employees = new Employees();
		employees.setId(id);
		employees.setStatus(2);
		employeesService.deleteEmployee(employees);
		return new JSONResult("200", "success", null, null);
	}
	@RequestMapping("selectById")
	//传入病人id查询病人对应科室的医生
	public JSONResult selectDocById(Integer id)throws Exception{
		return new JSONResult("200","success",employeesService.selectDocById(id),null);

	}
	@RequestMapping("selectNurById")
	//传入病人id查询病人对应科室的护士
	public JSONResult selectNurById(Integer id)throws Exception{
		return new JSONResult("200","success",employeesService.selectNurById(id),null);

	}
}

