package com.woniuxy.cq.soft.service;
import com.woniuxy.cq.soft.entity.Appointment;
import com.woniuxy.cq.soft.entity.Beds;
import com.woniuxy.cq.soft.entity.Department;
import com.woniuxy.cq.soft.entity.User;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
public interface UserService {
	/**
	 * @Title: selectUser
	 * @Description: TODO
	 * @param: @param user
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: Object 返回类型 
	 * @tags: 登录
	 */
	public User selectUserByPhone(String phone) throws Exception;
	/**
	 * @Title: insertUser
	 * @Description: TODO
	 * @param: @param user
	 * @param: @throws Exception 参数 
	 * @return: void 返回类型 
	 * @tags: 注册
	 */
	public void insertUser(User user) throws Exception;
	//查询部门
	List<Department> queryDepartment() throws Exception;
	//根据部门查询床位
	List<Beds> queryBed(Integer depid) throws Exception;
	//新增预约信息
	void insertApp(Appointment app) throws Exception;
	//查询预约信息
	Object queryApp(User u, int pageNum, int pageSize) throws Exception;
}
