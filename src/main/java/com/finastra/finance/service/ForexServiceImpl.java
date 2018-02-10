package com.finastra.finance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.finance.model.Employee;
import com.finastra.finance.model.Forex;
import com.finastra.finance.repository.EmployeeRepository;
import com.finastra.finance.repository.ForexRepository;
import com.finastra.finance.repository.ItineraryRepository;

@Service
public class ForexServiceImpl implements ForexService
{
	@Autowired
	private ForexRepository forexRepository;
	
	@Autowired
	private ItineraryRepository itineraryRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void save(Forex forex) 
	{
		forexRepository.save(forex);		
	}

	@Override
	public List<Forex> getAllForexItemsByUser(String email) 
	{
		return forexRepository.findAllByUserId(email);
	}

	@Override
	public Forex getForex(int id) {
		Forex f = new Forex();
		f = forexRepository.findOne(id);
		f.setItineraryLst(itineraryRepository.getItineraryLst(id));
		return f;
	}

	@Override
	public List<Forex> getAllForexReqByUserId(String email) {
		
		return forexRepository.findAllForexReqByUserId(email);
	}

	@Override
	public void setInitialData(Forex frx, String email) 
	{
		Employee emp = employeeRepository.getEmployeeByEmail(email);
		frx.setEmp_nm(emp.getEmp_nm());
		frx.setEmail(emp.getEmail());
		frx.setDob_dt(emp.getDob());
		frx.setProj_code(emp.getProject_code());
		frx.setProj_nm(emp.getProject_name());
		frx.setPassport_num(emp.getPassport_no());
		frx.setPassport_iss_dt(emp.getPassport_issue_date());
		frx.setPassport_exp_dt(emp.getPassport_expiry_date());
		frx.setUid(emp.getUid());
		frx.setMobile(emp.getMobile());
		frx.setManager_nm(emp.getManager_nm());
	}

	@Override
	public List<Forex> getAllForexForApproval(String email) 
	{
		Employee emp = employeeRepository.getEmployeeByEmail(email);
		String financeSts = "STS_02";
		List<Forex> frxLst = new ArrayList<Forex>();
		if("MANAGER".equals(emp.getEmp_role()))
		{
			frxLst.addAll(forexRepository.findAllForexPendingFromManager(emp.getEmp_no()));
		}
		else if("FINANCE".equals(emp.getEmp_role()))
		{
			frxLst.addAll(forexRepository.findAllForexPendingFromFinance(emp.getEmp_no(), financeSts));
		}
		
		return frxLst;
	}

}
