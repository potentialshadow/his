package com.woniuxy.cq.soft.entity;

public class EmployeesVO extends BaseVO{
	private Integer id;
	private String phone;
	private String password;
	private String name;
	private Integer age;
	private Integer sex;
	private Integer rid;
	private Integer did;
	private String rName;
	private String deptName;
	private Integer status;
	public EmployeesVO() {
		// TODO Auto-generated constructor stub
	}
	public EmployeesVO(Integer id, String phone, String password, String name, Integer age, Integer sex, Integer rid,
			Integer did, String rName, String deptName, Integer status) {
		super();
		this.id = id;
		this.phone = phone;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.rid = rid;
		this.did = did;
		this.rName = rName;
		this.deptName = deptName;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "EmployeesVO [id=" + id + ", phone=" + phone + ", password=" + password + ", name=" + name + ", age="
				+ age + ", sex=" + sex + ", rid=" + rid + ", did=" + did + ", rName=" + rName + ", deptName=" + deptName
				+ ", status=" + status + "]";
	}
}
