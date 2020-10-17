package com.woniuxy.cq.soft.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Drug;
import com.woniuxy.cq.soft.entity.DrugRecords;
import com.woniuxy.cq.soft.entity.RefundDetails;

public interface DrugService {

	PageInfo query(String name, String item, int pageNum, int pageSize)throws Exception;

	Drug queryNum(String name) throws Exception;

	void insertRecord(DrugRecords drug) throws Exception;

	Object queryRecord(String name, String drugitem, int pageNum, int pageSize) throws Exception;

	Object queryMess(String name, int pageNum, int pageSize) throws Exception;

	Object queryMessById(Integer id) throws Exception;

	void updateMessById(Drug dr) throws Exception;

	void deleteMessById(Integer id) throws Exception;

	void insertMess(Drug de);

	Object qureryReturnMess(String name, int pageNum, int pageSize);

	void updateRuterunMess(RefundDetails re);

	Object nursQureryMess(String name, int pageNum, int pageSize);

	void updateNruRuterunMess(RefundDetails re);

}
