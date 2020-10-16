package com.woniuxy.cq.soft.service;


import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.MoneyDetail;

public interface MoneyDetailService {
	PageInfo<Map<String, Object>> selectMoneyDetail(Integer paid,int pageNum,int pageSize)throws Exception;
	List<MoneyDetail> selectMoneyDetailByPaid(Integer paid)throws Exception;

}
