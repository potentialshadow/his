package com.woniuxy.cq.soft.controller;


import javax.annotation.Resource;

import com.woniuxy.cq.soft.entity.Appointment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.cq.soft.entity.User;
import com.woniuxy.cq.soft.service.UserService;
import com.woniuxy.cq.soft.util.JSONResult;
import com.woniuxy.cq.soft.util.MD5Utils;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author potentialshadow
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	/**
	 * @Title: loginVerify
	 * @Description: TODO
	 * @param: @param user
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: 登录界面
	 */
	@RequestMapping("login")
	public JSONResult loginVerify(User user) throws Exception{
		String password = user.getPassword();
		password = MD5Utils.MD5EncodeUtf8(password);
		user.setPassword(password);
		User userByPhone = userService.selectUserByPhone(user.getPhone());
		JSONResult result = new JSONResult();
		if(userByPhone!=null) {
			if(userByPhone.getPassword().equals(user.getPassword())) {
				result.setCode("200");
				result.setMessage("success");
				result.setObj(userByPhone);
			}else {
				result.setCode("410");
				result.setMessage("密码错误");
			}
		}
		return result;
	}
	/**
	 * @Title: registerUser
	 * @Description: TODO
	 * @param: @param user
	 * @param: @return
	 * @param: @throws Exception 参数 
	 * @return: JSONResult 返回类型 
	 * @tags: 用户注册
	 */
	@RequestMapping("register")
	public JSONResult registerUser(User user) throws Exception{
		String password=user.getPassword();
		password = MD5Utils.MD5EncodeUtf8(password);
		user.setPassword(password);
		User userByPhone = userService.selectUserByPhone(user.getPhone());
		if(userByPhone!=null) {
			return new JSONResult("408", "该手机号已注册,请登录!!!", null, null);
		}else {
			userService.insertUser(user);
			return new JSONResult("200", "success", null, null);
		}
	}
	//查询全部科室
	@RequestMapping("departmentMapper")
	public JSONResult queryDepartment() throws Exception{

		return new JSONResult("200","success",userService.queryDepartment(),null);
	}

	//根据部门查询床位
	@RequestMapping("bed")
	public JSONResult queryBed(Integer depid) throws Exception{
		System.out.println(depid);
		return new JSONResult("200","success",userService.queryBed(depid),null);
	}
	//新增预约数据
	@RequestMapping("app")
	public JSONResult insertApp(Appointment app) throws Exception{
		//通过权限获取用户的ID，在set进去
		//Subject subject = SecurityUtils.getSubject();
		//User user = (User)subject.getPrincipal();
		userService.insertApp(app);
		return new JSONResult("200","success",null,null);
	}
	//查询预约数据
	@RequestMapping("query")
	public JSONResult queryApp(@RequestBody Map<String,Object> map) throws Exception{
		//通过权限获取用户的ID，查询信息
		//Subject subject = SecurityUtils.getSubject();
		//User user = (User)subject.getPrincipal();
		User u=new User();
		u.setId(1);
		int	pageNum=(int) map.get("pageNum");
		int	pageSize=(int) map.get("pageSize");

		return new JSONResult("200","success",null,userService.queryApp(u,pageNum,pageSize));
	}
}

