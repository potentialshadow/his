package com.woniuxy.cq.soft.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.Appointment;
import com.woniuxy.cq.soft.entity.AppointmentExample;
import com.woniuxy.cq.soft.entity.MoneyDetail;
import com.woniuxy.cq.soft.entity.MoneyDetailExample;
import com.woniuxy.cq.soft.entity.Patient;
import com.woniuxy.cq.soft.entity.PatientExample;
import com.woniuxy.cq.soft.entity.PatientExample.Criteria;
import com.woniuxy.cq.soft.mapper.AppointmentMapper;
import com.woniuxy.cq.soft.mapper.MoneyDetailMapper;
import com.woniuxy.cq.soft.mapper.PatientMapper;
import com.woniuxy.cq.soft.service.MoneyService;

@Service
public class MoneyServiceImpl implements MoneyService{
	@Resource
	private MoneyDetailMapper MD;
	@Resource
	private PatientMapper pat;
	@Resource
	private AppointmentMapper appoMapper;
	@Override
	public void insertMoney(Patient pat01) {
		//查询出用户病例id
		int pid;
		PatientExample example = new PatientExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdCardEqualTo(pat01.getIdCard());
		criteria.andPhoneEqualTo(pat01.getPhone());
		List<Patient> list = pat.selectByExample(example);
		if(list.size()>0) {
			//修改病例总金额
			Patient patient =list.get(0);
			Double money=patient.getMoney()+pat01.getMoney();
			patient.setMoney(money);
			pat.updateByPrimaryKey(patient);
			//把钱存入money明细表
			MoneyDetail detail = new MoneyDetail();
			detail.setMoney(pat01.getMoney());
			detail.setDetail("预存缴纳:+"+pat01.getMoney());
			detail.setPatid(patient.getId());
			detail.setStatus(1);
			MD.insertSelective(detail);
		}
	}
	//出院结算查询
	@Override
	public Map<String, Object> selectByCardId(Integer cardId,Integer	pageNumber) {
		Map<String,Object> map=new HashMap<String,Object>(); 
		//查询当前病人
		PatientExample example = new PatientExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdCardEqualTo(cardId+"");
		List<Patient> list = pat.selectByExample(example);
		if(list.size()>0) {
			Patient patient = list.get(0);
			map.put("patient", patient);
			//查询出病人的消费详情记录
			MoneyDetailExample moneyexample = new MoneyDetailExample();
			MoneyDetailExample.Criteria criteria2 = moneyexample.createCriteria();
			criteria2.andPatidEqualTo(patient.getId());
			PageHelper.startPage(pageNumber, 3);
			List<MoneyDetail> list2 = MD.selectByExample(moneyexample);
			PageInfo<MoneyDetail> pageinfo=new PageInfo<MoneyDetail>(list2);
			
			map.put("list", pageinfo);
		}
		return map;
	}
	@Override
	public Map<String, Object> selectByTime(Integer cardId,Integer	pagenumber) {
		Map<String,Object> map=new HashMap<String,Object>(); 
		//查询当前病人
		PatientExample example = new PatientExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdCardEqualTo(cardId+"");
		List<Patient> list = pat.selectByExample(example);
		if(list.size()>0) {
			Patient patient = list.get(0);
			map.put("patient", patient);
			//查询出病人当日的消费详情记录
			PageHelper.startPage(pagenumber, 3);
			List<MoneyDetail> list2 = MD.selectByTime(patient.getId());
			//当日消费总额
			double	money=0.0;
			for(MoneyDetail m:list2) {
				money=money+m.getMoney();
			}
			map.put("money", money);
			PageInfo<MoneyDetail> pageinfo=new PageInfo<MoneyDetail>(list2);
			map.put("list", pageinfo);
		}
		return map;
	}
	@Override
	//根据收费条件查询消费详情
	public Map<String, Object> selectByStatus(Integer pid,Integer status,Integer pagenumber) {
		Map<String,Object> map=new HashMap<String,Object>();
		MoneyDetailExample moneyexample = new MoneyDetailExample();
		MoneyDetailExample.Criteria criteria2 = moneyexample.createCriteria();
		if(status!=0) {
			criteria2.andStatusEqualTo(status);
		}
		criteria2.andPatidEqualTo(pid);
		PageHelper.startPage(pagenumber, 3);
		List<MoneyDetail> list2 = MD.selectByExample(moneyexample);
		PageInfo<MoneyDetail> pageinfo=new PageInfo<MoneyDetail>(list2);
		map.put("list", pageinfo);
		return map;
	}
	
	//根据病人出入院状态查询
	@Override
	public PageInfo<Patient> selectPatientByStatus(String status,Integer pagenumber) {
		PatientExample example = new PatientExample();
		Criteria criteria = example.createCriteria();
		if(status!=null&&status!="") {
			criteria.andStatusEqualTo(status);
		}
		PageHelper.startPage(pagenumber, 3);
		List<Patient> list = pat.selectByExample(example);
		PageInfo<Patient> pageinfo=new PageInfo<Patient>(list);
		return pageinfo;
	}
	
	//出院结算余额
	@Override
	public void updateMoneyByPatid(Integer pid, Double money) {
		//新增一条费用信息
		MoneyDetail detail = new MoneyDetail();
		detail.setPatid(pid);
		if(money>0) {
			detail.setDetail("出院结算:-"+money);
			detail.setStatus(2);
			detail.setMoney(money);
			MD.insertSelective(detail);
		}
		if(money<0) {
			detail.setDetail("出院结算:+"+money);
			detail.setStatus(1);
			detail.setMoney(-money);
			MD.insertSelective(detail);
		}
		//余额清零
		Patient patient = new Patient();
		patient.setMoney(0.0);
		patient.setStatus("出院");
		patient.setId(pid);
		pat.updateByPrimaryKeySelective(patient);
	}
	
	@Override
	public void updateAppoStatus(Integer id, Integer status) {
		/** 
		* @author 作者:jiejiang E-mail:1289687985@qq.com: 
		* @version 创建时间：2020年10月16日 上午11:59:27 
		* 方法说明 :修改预约信息状态
		*/ 
		Appointment appointment = new Appointment();
		appointment.setId(id);
		appointment.setStatus(status);
		appoMapper.updateByPrimaryKey(appointment);
	}
	
	@Override
	public PageInfo<Appointment> selectAppos(Integer pageNum, Integer pageSize) {
		/** 
		* @author 作者:jiejiang E-mail:1289687985@qq.com: 
		* @version 创建时间：2020年10月16日 下午12:17:48 
		* 方法说明 :查询所有状态为未通过的申请表
		*/ 
		AppointmentExample example = new AppointmentExample();
		AppointmentExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(0);
		PageHelper.startPage(pageNum, pageSize);
		List<Appointment> list = appoMapper.selectByExample(example);
		PageInfo<Appointment> pageInfo = new PageInfo<Appointment>(list);
		return pageInfo;
	}
}
