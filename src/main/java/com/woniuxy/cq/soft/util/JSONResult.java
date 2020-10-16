package com.woniuxy.cq.soft.util;

import java.util.List;

public class JSONResult {
	private String code;
	private String message;
	private List<?> list;
	private Object obj;
	public JSONResult() {
		// TODO Auto-generated constructor stub
	}
	public JSONResult(String code, String message, List<?> list, Object obj) {
		super();
		this.code = code;
		this.message = message;
		this.list = list;
		this.obj = obj;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "JSONresult [code=" + code + ", message=" + message + ", list=" + list + ", obj=" + obj + "]";
	}
}
