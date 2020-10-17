package com.woniuxy.cq.soft.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.*;
import com.woniuxy.cq.soft.mapper.AppointmentMapper;
import com.woniuxy.cq.soft.mapper.BedsMapper;
import com.woniuxy.cq.soft.mapper.DepartmentMapper;
import com.woniuxy.cq.soft.mapper.UserMapper;
import com.woniuxy.cq.soft.service.UserService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private DepartmentMapper departmentMapper;
	@Resource
	private BedsMapper bedsMapper;


	@Resource
	private AppointmentMapper appointmentMapper;

	@Override
	public User selectUserByPhone(String phone) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(phone);
		List<User> list = userMapper.selectByExample(example);
		User user=new User();
		if(list!=null&&!list.isEmpty()){
			user= list.get(0);
		}
		return user;
	}
	@Override
	public void insertUser(User user) throws Exception {
		userMapper.insertSelective(user);
	}
	//查询部门
	@Override
	public List<Department> queryDepartment() throws Exception{
		DepartmentExample example = new DepartmentExample();
		example.createCriteria().andStatusEqualTo(0);

		return departmentMapper.selectByExample(example);
	}
	//查询部门查询床位空余床位
	@Override
	public List<Beds> queryBed(Integer depid) throws Exception{
		BedsExample example = new BedsExample();
		if(depid != null && depid != 0 && !depid.equals("")) {
			example.createCriteria().andDepidEqualTo(depid).andStatusEqualTo(0);
		}else {
			example.createCriteria().andStatusEqualTo(0);
		}

		return bedsMapper.selectByExample(example);
	}
	//新增预约信息
	@Override
	public void insertApp(Appointment app) throws Exception{
		//app的id是部门id
		Department de=departmentMapper.selectByPrimaryKey(app.getId());
		app.setDepartment(de.getName());
		app.setId(null);
		appointmentMapper.insertSelective(app);
	}
	//查询预约信息
	@Override
	public Object queryApp(User u, int pageNum, int pageSize) throws Exception{
		AppointmentExample example = new AppointmentExample();
		example.createCriteria().andUidEqualTo(u.getId());
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<Appointment> list = appointmentMapper.selectByExample(example);
		PageInfo<Appointment> info = new PageInfo<Appointment>(list);
		return info;
	}
}
