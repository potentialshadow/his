package com.woniuxy.cq.soft.entity;

public class BaseVO {
	private Integer page;
	private Integer num;
	public BaseVO() {
		// TODO Auto-generated constructor stub
	}
	public BaseVO(Integer page, Integer num) {
		super();
		this.page = page;
		this.num = num;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "BaseVO [page=" + page + ", num=" + num + "]";
	}
}
