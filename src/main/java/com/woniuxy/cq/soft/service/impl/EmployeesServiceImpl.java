package com.woniuxy.cq.soft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.woniuxy.cq.soft.entity.*;
import com.woniuxy.cq.soft.mapper.DepartmentMapper;
import com.woniuxy.cq.soft.mapper.PatientMapper;
import com.woniuxy.cq.soft.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.mapper.EmployeesMapper;
import com.woniuxy.cq.soft.service.EmployeesService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
@Service
public class EmployeesServiceImpl implements EmployeesService {
	@Resource
	private EmployeesMapper employeesMapper;
	@Resource
	private PatientMapper patientMapper;
	@Resource
	private DepartmentMapper departmentMapper;
	@Resource
	private RoleMapper roleMapper;
	@Override
	public Employees selectByPhone(String phone) throws Exception {
		EmployeesExample example = new EmployeesExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<Employees> list = employeesMapper.selectByExample(example);
		if(list!=null||!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public PageInfo<EmployeesVO> selectEmployees(String context,EmployeesVO employeesVO) throws Exception {
		//设置页码和每页显示数量
		PageHelper.startPage(employeesVO.getPage(), employeesVO.getNum());
		//4.执行查询，并封装为PageInfo数据
		List<EmployeesVO> list = employeesMapper.selectEmployees(context,employeesVO.getStatus());
		PageInfo<EmployeesVO> pageInfo=new PageInfo<EmployeesVO>(list);
		return pageInfo;
	}
	@Override
	public void insertEmployee(Employees employee) throws Exception {
		employeesMapper.insertSelective(employee);
	}
	@Override
	public Employees selectEmployeeById(Integer id) throws Exception {
		return employeesMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateEmployee(Employees employee) throws Exception {
		employeesMapper.updateByPrimaryKeySelective(employee);
	}
	@Override
	public void deleteEmployee(Employees employees) throws Exception {
		employeesMapper.updateByPrimaryKeySelective(employees);
	}
	//通过病人id查询病人科室，在查询对应科室的医生
	@Override
	public List<Employees> selectDocById(Integer id) throws Exception {
		Patient patient = patientMapper.selectByPrimaryKey(id);
		String department = patient.getDepartment();
		DepartmentExample example = new DepartmentExample();
		example.createCriteria().andNameEqualTo(department);
		List<Department> list = departmentMapper.selectByExample(example);
		Department department2 = list.get(0);
		RoleExample example3 = new RoleExample();
		example3.createCriteria().andRoleNameEqualTo("医生");
		List<Role> list2 = roleMapper.selectByExample(example3);
		Role role = list2.get(0);
		EmployeesExample example2 = new EmployeesExample();
		example2.createCriteria().andDidEqualTo(department2.getId()).andRidEqualTo(role.getId());
		return employeesMapper.selectByExample(example2);
	}
	//通过病人id查询病人科室，在查询对应科室的护士
	@Override
	public List<Employees> selectNurById(Integer id) throws Exception {
		Patient patient = patientMapper.selectByPrimaryKey(id);
		String department = patient.getDepartment();
		DepartmentExample example = new DepartmentExample();
		example.createCriteria().andNameEqualTo(department);
		List<Department> list = departmentMapper.selectByExample(example);
		Department department2 = list.get(0);
		RoleExample example3 = new RoleExample();
		example3.createCriteria().andRoleNameEqualTo("护士");
		List<Role> list2 = roleMapper.selectByExample(example3);
		Role role = list2.get(0);
		EmployeesExample example2 = new EmployeesExample();
		example2.createCriteria().andDidEqualTo(department2.getId()).andRidEqualTo(role.getId());
		return employeesMapper.selectByExample(example2);
	}


}
