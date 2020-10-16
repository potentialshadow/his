package com.woniuxy.cq.soft.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Nursing;

public interface NursingService {
	PageInfo<Map<String, Object>> selectNursings(int pageNum,int pageSize,Integer eid)throws Exception;
	void insertNursing(Nursing nursing)throws Exception;
	void deleteNursing(Integer id)throws Exception;
}
