package com.woniuxy.cq.soft.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.woniuxy.cq.soft.entity.*;
import com.woniuxy.cq.soft.mapper.*;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.cq.soft.entity.PatientExample.Criteria;
import com.woniuxy.cq.soft.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {
	@Resource
	private PatientMapper patientMapper;
	@Resource
	private BedsMapper bedsMapper;
	@Resource
	private EmployeesMapper employeesMapper;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private DoctorAdviceMapper doctorAdviceMapper;
	@Resource
	private DoctorAdviceDetailsMapper doctorAdviceDetailsMapper;
	@Resource
	private MoneyDetailMapper moneyDetailMapper;
	@Resource
	private AppointmentMapper appointmentMapper;
	@Resource
	private DepartmentMapper departmentMapper;
	@Override
	//病历表新增数据
	public void insertPatient(Patient patient) throws Exception {
		Integer appid = patient.getId();
		Appointment appointment = new Appointment();
		appointment.setId(appid);
		appointment.setStatus(3);
		appointmentMapper.updateByPrimaryKeySelective(appointment);
		patient.setId(null);
		patientMapper.insertSelective(patient);
	}

	@Override
	public PageInfo<Patient> selectPatients(Integer pageNum,Integer pageSize) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		List<Patient> list = patientMapper.selectByExample(null);
		PageInfo<Patient> pageInfo = new PageInfo<Patient>(list);
		return pageInfo;
	}

	@Override
	public void updatePatientBeds(Integer id) throws Exception {
		Patient patient = new Patient();
		patient.setId(id);
		patient.setBeds("0");
		Patient patient2 = patientMapper.selectByPrimaryKey(id);
		patientMapper.updateByPrimaryKeySelective(patient);
		BedsExample example = new BedsExample();
		example.createCriteria().andRoomEqualTo(patient2.getBeds());
		List<Beds> list = bedsMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			Beds beds = list.get(0);
			Beds beds2 = new Beds();
			beds2.setStatus(0);
			beds2.setId(beds.getId());
			bedsMapper.updateByPrimaryKeySelective(beds2);
		}
		
	}
	@Override
	public void updatePatientBedsByname(Integer id,String room) throws Exception {
		Patient patient = new Patient();
		patient.setId(id);
		patient.setBeds(room);
		System.out.println(id);
		System.out.println(room);
		patientMapper.updateByPrimaryKeySelective(patient);
		Beds beds = new Beds();
		beds.setStatus(1);
		BedsExample example = new BedsExample();
		example.createCriteria().andRoomEqualTo(room);
		bedsMapper.updateByExampleSelective(beds, example);
	}

	@Override
	public PageInfo<Patient> selectPatient(Integer pageNum, Integer pageSize, String name,String status) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		PatientExample example = new PatientExample();
		Criteria criteria = example.createCriteria();
		if(name!=null && name!="") {
			criteria.andNameEqualTo(name);
		}
		if(status!=null && status!="") {

			criteria.andStatusEqualTo(status);
		}
		List<Patient> list = patientMapper.selectByExample(example);
		PageInfo<Patient> pageInfo = new PageInfo<Patient>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Patient> selectPByStatus(Integer pageNum, Integer pageSize,Integer did) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		Department department=departmentMapper.selectByPrimaryKey(did);
		PatientExample example = new PatientExample();
		example.createCriteria().andDepartmentEqualTo(department.getName()).andStatusEqualTo("在院");
		List<Patient> list = patientMapper.selectByExample(example);
		PageInfo<Patient> pageInfo = new PageInfo<Patient>(list);
		return pageInfo;
	}
	//给病人指派医生、护士
	@Override
	public void insertEmp(Integer id,Integer paid) throws Exception {
		Employees employees = employeesMapper.selectByPrimaryKey(id);
		RoleExample example = new RoleExample();
		example.createCriteria().andRoleNameEqualTo("医生");
		List<Role> list = roleMapper.selectByExample(example);
		Role role = list.get(0);
		//判断employees为医生还是护士
		if(role.getId()==employees.getRid()) {
			Patient patient = new Patient();
			patient.setEid(employees.getId());
			patient.setEname(employees.getName());
			patient.setId(paid);
			patientMapper.updateByPrimaryKeySelective(patient);
		}else {
			Patient patient = new Patient();
			patient.setEmid(employees.getId());
			patient.setEmname(employees.getName());
			patient.setId(paid);
			patientMapper.updateByPrimaryKeySelective(patient);
		}
	
	}

	@Override
	public List<Map<String, Object>> selectMedical(Integer paid) throws Exception {
		
		return doctorAdviceMapper.selectMedicalByPaid(paid);
	}

	@Override
	public void updateMedical(Integer id,Integer paid) throws Exception {
		DoctorAdviceDetails details = new DoctorAdviceDetails();
		details.setId(id);
		details.setStatus("1");
		doctorAdviceDetailsMapper.updateByPrimaryKeySelective(details);
		DoctorAdviceDetails doctorAdviceDetails = doctorAdviceDetailsMapper.selectByPrimaryKey(id);
		Patient patient = patientMapper.selectByPrimaryKey(paid);
		MoneyDetail moneyDetail = new MoneyDetail();
		moneyDetail.setMoney(doctorAdviceDetails.getNumber()*doctorAdviceDetails.getPrice());
		moneyDetail.setPatid(paid);
		moneyDetail.setStatus(2);
		if(doctorAdviceDetails.getType().equals("检查")) {
			moneyDetail.setDetail("检查-"+doctorAdviceDetails.getNumber()*doctorAdviceDetails.getPrice());
			
		}else if(doctorAdviceDetails.getType().equals("手术")) {
			moneyDetail.setDetail("手术-"+doctorAdviceDetails.getNumber()*doctorAdviceDetails.getPrice());
			
		}else {
			moneyDetail.setDetail("药品-"+doctorAdviceDetails.getNumber()*doctorAdviceDetails.getPrice());
		}
		moneyDetailMapper.insertSelective(moneyDetail);
		Patient patient2 = new Patient();
		patient2.setMoney(patient.getMoney()-doctorAdviceDetails.getNumber()*doctorAdviceDetails.getPrice());
		patient2.setId(paid);
		patientMapper.updateByPrimaryKeySelective(patient2);
	}

}
