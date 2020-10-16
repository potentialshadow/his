package com.woniuxy.cq.soft;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.MoneyDetail;
import com.woniuxy.cq.soft.mapper.MoneyDetailMapper;
import com.woniuxy.cq.soft.service.DrugService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HisApplication.class)
class HisApplicationTests {
	@Resource
	private  MoneyDetailMapper moneyDetailMapper;
	@Test
	void xxxx() {
		
		MoneyDetail detail = new MoneyDetail();
		detail.setDetail("退药");
		detail.setPatid(1);
		detail.setMoney(20.0);
		moneyDetailMapper.insertSelective(detail);
	}

}
