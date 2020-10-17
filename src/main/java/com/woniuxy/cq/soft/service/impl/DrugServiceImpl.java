package com.woniuxy.cq.soft.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.DoctorAdvice;
import com.woniuxy.cq.soft.entity.DoctorAdviceDetails;
import com.woniuxy.cq.soft.entity.DoctorAdviceDetailsExample;
import com.woniuxy.cq.soft.entity.DoctorAdviceExample;
import com.woniuxy.cq.soft.entity.Drug;
import com.woniuxy.cq.soft.entity.DrugExample;
import com.woniuxy.cq.soft.entity.DrugExample.Criteria;
import com.woniuxy.cq.soft.entity.DrugRecords;
import com.woniuxy.cq.soft.entity.DrugRecordsExample;
import com.woniuxy.cq.soft.entity.MoneyDetail;
import com.woniuxy.cq.soft.entity.Patient;
import com.woniuxy.cq.soft.entity.PatientExample;
import com.woniuxy.cq.soft.entity.RefundDetails;
import com.woniuxy.cq.soft.entity.RefundDetailsExample;
import com.woniuxy.cq.soft.mapper.DoctorAdviceDetailsMapper;
import com.woniuxy.cq.soft.mapper.DoctorAdviceMapper;
import com.woniuxy.cq.soft.mapper.DrugMapper;
import com.woniuxy.cq.soft.mapper.DrugRecordsMapper;
import com.woniuxy.cq.soft.mapper.MoneyDetailMapper;
import com.woniuxy.cq.soft.mapper.PatientMapper;
import com.woniuxy.cq.soft.mapper.RefundDetailsMapper;
import com.woniuxy.cq.soft.service.DrugService;
@Service
public class DrugServiceImpl implements DrugService{
	@Resource
	private DoctorAdviceDetailsMapper doctorAdviceDetailsMapper;
	@Resource
	private DrugMapper  drugMapper;
	@Resource
	private DrugRecordsMapper drugRecordsMapper;
	@Resource
	private RefundDetailsMapper  RefundDetailsMapper;
	@Resource
	private DoctorAdviceMapper doctorAdviceMapper;
	@Resource
	private MoneyDetailMapper  moneyDetailMapper;
	@Resource
	private PatientMapper patientMapper;
	//条件查询医嘱
	@Override
	public PageInfo query(String name, String item, int pageNum, int pageSize) throws Exception{
		//查询出用户的id
		int id=0;
		if(item !=null && item != "") {
			id = Integer.parseInt(item);
			System.out.println(id);
		}
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<Map> list = doctorAdviceDetailsMapper.queryAoctorAdvice(name,id);
		PageInfo<Map> pageInfo=new PageInfo<Map>(list);
		return pageInfo;
	}
	//根据药品名字查询库存数量
	@Override
	public Drug queryNum(String name) throws Exception{
		DrugExample example = new DrugExample();
		Criteria criteria = example.createCriteria().andDrugNameEqualTo(name);
		List<Drug> list = drugMapper.selectByExample(example);
		return list.get(0);
	}
	//新增药房取药记录
	@Override
	public void insertRecord(DrugRecords drug) throws Exception{
		Drug drug2 = new Drug();
		drug2.setDrugName(drug.getName());
		drug2.setNumber(drug.getNumber());
		//药房减少数量
		drugMapper.updataNumber(drug2);

		//处方药要改为已取药
		DoctorAdviceDetails doctorAdviceDetails = new DoctorAdviceDetails();
		doctorAdviceDetails.setId(drug.getDdid());
		doctorAdviceDetails.setStatus("已取药");
		doctorAdviceDetailsMapper.updateByPrimaryKeySelective(doctorAdviceDetails);
		//新增药品出库记录
		drugRecordsMapper.insertSelective(drug);
	}
	//动态查询药品出库记录
	@Override
	public Object queryRecord(String name, String paname, int pageNum, int pageSize) throws Exception{
		
		DrugRecordsExample example = new DrugRecordsExample();
		if(name != null && name !="") {
			
			 example.createCriteria().andNameLike("%"+name+"%");
		};
		if(paname != null && paname !="") {
			
			example.createCriteria().andPanameLike("%"+paname+"%");
		};
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<DrugRecords> list = drugRecordsMapper.selectByExample(example);
		PageInfo<DrugRecords> pageInfo=new PageInfo<DrugRecords>(list);
		
		return pageInfo;
	}
	//动态查询药品信息
	@Override
	public Object queryMess(String name, int pageNum, int pageSize) throws Exception{
		DrugExample example = new DrugExample();
		if(name != null && name !="") {
			example.createCriteria().andDrugNameLike("%"+name+"%");
		};
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<Drug> list = drugMapper.selectByExample(example);
		PageInfo<Drug> pageInfo=new PageInfo<Drug>(list);
		return pageInfo;
	}
	//根据id查询药品信息
	@Override
	public Object queryMessById(Integer id) throws Exception{
		DrugExample example = new DrugExample();
		example.createCriteria().andIdEqualTo(id);
		List<Drug> list = drugMapper.selectByExample(example);
		return list.get(0);
	}
	//更新药品信息
	@Override
	public void updateMessById(Drug dr) throws Exception{
		
		drugMapper.updateByPrimaryKey(dr);
	}
	//根据ID删除
	@Override
	public void deleteMessById(Integer id) throws Exception {
		drugMapper.deleteByPrimaryKey(id);
		
	}
	//新增药品信息
	@Override
	public void insertMess(Drug de) {
		drugMapper.insert(de);
	}
	//药房查询申请退药
	@Override
	public Object qureryReturnMess(String name, int pageNum, int pageSize) {
		RefundDetailsExample example = new RefundDetailsExample();
		if(name != null && name !="") {
			
			 example.createCriteria().andNameLike("%"+name+"%");
		};
		example.createCriteria().andStatusEqualTo("2");
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<RefundDetails> list = RefundDetailsMapper.selectByExample(example);
		PageInfo pageInfo = new PageInfo<RefundDetails>(list);
		return pageInfo;
	}
	//申请退药通过
	@Override
	public void updateRuterunMess(RefundDetails re) {
		re.setStatus("4");
		RefundDetailsMapper.updateByPrimaryKeySelective(re);
		//药品库存增加
		DrugExample example4 = new DrugExample();
		example4.createCriteria().andDrugNameEqualTo(re.getName());
		List<Drug> list4 = drugMapper.selectByExample(example4);
		Drug drug = list4.get(0);
		Drug drug2 = new Drug();
		drug2.setId(drug.getId());
		drug2.setNumber(drug.getNumber()+re.getNumber());
		drugMapper.updateByPrimaryKeySelective(drug2);
		
		//通过医嘱详情查询医嘱的ID
		DoctorAdviceDetailsExample example = new DoctorAdviceDetailsExample();
		 example.createCriteria().andIdEqualTo(re.getDdid());
		 List<DoctorAdviceDetails> list = doctorAdviceDetailsMapper.selectByExample(example);
		 DoctorAdviceDetails details = list.get(0);
		//查询医嘱的ID得到病人的ID 
		 DoctorAdviceExample example2 = new DoctorAdviceExample();
		 example2.createCriteria().andIdEqualTo(details.getDid());
		 List<DoctorAdvice> list2 = doctorAdviceMapper.selectByExample(example2);
		 DoctorAdvice advice = list2.get(0);
		//新增费用详情
		MoneyDetail detail = new MoneyDetail();
		
		 detail.setMoney(re.getMoney());
		 detail.setDetail("退药费:+"+re.getMoney());
		 detail.setPatid(advice.getPaid());
		detail.setStatus(1);
		 moneyDetailMapper.insertSelective(detail);
		 //通过病人的ID查询病人的信息
		 PatientExample example3 = new PatientExample();
		 example3.createCriteria().andIdEqualTo(advice.getPaid());
		 List<Patient> list3 = patientMapper.selectByExample(example3);
		
		 Patient patient = list3.get(0);
		
		 Patient patient2 = new Patient();
		 patient2.setId(patient.getId());
		 patient2.setMoney(patient.getMoney()+re.getMoney());
		 //修改病人的余额
		 patientMapper.updateByPrimaryKeySelective(patient2);
	}
	//护士查询退药申请
	@Override
	public Object nursQureryMess(String name, int pageNum, int pageSize) {
		RefundDetailsExample example = new RefundDetailsExample();
		if(name != null && name !="") {
			
			 example.createCriteria().andNameLike("%"+name+"%");
		};
		example.createCriteria().andStatusEqualTo("1");
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		List<RefundDetails> list = RefundDetailsMapper.selectByExample(example);
		PageInfo<RefundDetails> pageInfo=new PageInfo<RefundDetails>(list);
		return pageInfo;
	}
	//护士退药审批和退回
	@Override
	public void updateNruRuterunMess(RefundDetails re) {

		re.setStatus(re.getDdid()+"");
		re.setDdid(null);
		RefundDetailsMapper.updateByPrimaryKeySelective(re);
	}
}
