package com.woniuxy.cq.soft.service;

import java.util.List;

import com.woniuxy.cq.soft.entity.Beds;

public interface BedsService {
	List<Beds> selectBeds(Integer depid)throws Exception;
	List<Beds> selectBedsByDepartName(String name)throws Exception;
}
