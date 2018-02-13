package com.finastra.finance.service;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finastra.finance.model.Employee;
import com.finastra.finance.model.Forex;
import com.finastra.finance.model.ForexDetails;
import com.finastra.finance.model.Itinerary;
import com.finastra.finance.repository.EmployeeRepository;
import com.finastra.finance.repository.ForexDetailsRepository;
import com.finastra.finance.repository.ForexRepository;
import com.finastra.finance.repository.ItineraryRepository;
import com.finastra.finance.util.PdfGenaratorUtil;

@Service
@Transactional
public class ForexServiceImpl implements ForexService
{
	@Autowired
	private ForexRepository forexRepository;
	
	@Autowired
	private ItineraryRepository itineraryRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ForexDetailsRepository forexDtlsRepository;
	
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;
	
	@Autowired
	EmailService emailService;
	
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
		f.setForexDetailsLst(forexDtlsRepository.getForexDetailsLst(id));
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
		List<String> forexSts = new ArrayList<String>();
		List<Forex> frxLst = new ArrayList<Forex>();
		if("MANAGER".equals(emp.getEmp_role()))
		{
			forexSts.add("STS_01");
			frxLst.addAll(forexRepository.findAllForexPendingFromManager(emp.getEmp_no(), forexSts));
		}
		else if("FINANCE".equals(emp.getEmp_role()))
		{
			forexSts.add("STS_02");
			frxLst.addAll(forexRepository.findAllForexPendingFromFinance(emp.getEmp_no(), forexSts));
		}
		
		return frxLst;
	}

	@Override
	public void approveForex(int id, String action) 
	{
		Forex f = getForex(id);
		//Manager approval
		if("STS_01".equals(f.getStatus()) && "approve".equals(action))
		{
			f.setStatus("STS_02");
		}
		//Manager reject
		else if("STS_01".equals(f.getStatus()) && "reject".equals(action))
		{
			f.setStatus("STS_03");
		}
		//Finance Team reject
		else if("STS_02".equals(f.getStatus()) && "reject".equals(action))
		{
			f.setStatus("STS_04");
		}
		//Finance team approval.
		else
		{
			f.setStatus("STS_05");
		}

		forexRepository.saveAndFlush(f);
		
		String fileNm = f.getEmp_nm();
		createPDF(f,fileNm , "create_forex_pdf");
	}

	@Override
	@Transactional
	public void updateForex(Forex forex, int id, String action) 
	{
		Forex originalFrx = getForex(id);
		originalFrx.setStatus(forex.getStatus());
		originalFrx.setInput_user_mail(forex.getInput_user_mail());
		completeForex(originalFrx,forex);
	
		//Delete and insert
		List<Itinerary> itrLst = itineraryRepository.getItineraryLst(id);
		itineraryRepository.deleteInBatch(itrLst);
		
		List<ForexDetails> fdsLst = forexDtlsRepository.getForexDetailsLst(id);
		forexDtlsRepository.deleteInBatch(fdsLst);		
		
		originalFrx.getItineraryLst().clear();
		for(Itinerary itr:forex.getItineraryLst())
		{
			if(itr.getForex()!=null)
			{
				originalFrx.getItineraryLst().add(itr);
				originalFrx.addItinerary(itr);
			}
		}
		
		originalFrx.setForexDetailsLst(forex.getForexDetailsLst());
		for(ForexDetails fds:forex.getForexDetailsLst())
		{
			originalFrx.addForexDetails(fds);
		}	
		forexRepository.saveAndFlush(originalFrx);
	}

	@Override
	public void completeForex(Forex originalFrx, Forex newForex) 
	{
		originalFrx.setEmp_type(newForex.getEmp_type());
		originalFrx.setEmp_nm(newForex.getEmp_nm());
		originalFrx.setMother_nm(newForex.getMother_nm());
		originalFrx.setEmail(newForex.getEmail());
		originalFrx.setMobile(newForex.getMobile());
		originalFrx.setManager_nm(newForex.getManager_nm());
		originalFrx.setForex_card(newForex.getForex_card());
		originalFrx.setPurpose_of_trip(newForex.getPurpose_of_trip());
		originalFrx.setBillable(newForex.getBillable());
		originalFrx.setProj_code(newForex.getProj_code());
		originalFrx.setProj_nm(newForex.getProj_nm());
		originalFrx.setOpp_num(newForex.getOpp_num());
		originalFrx.setClient_nm(newForex.getClient_nm());
		originalFrx.setDob_dt(newForex.getDob_dt());
		
		originalFrx.setAdd_line_1(newForex.getAdd_line_1());
		originalFrx.setAdd_line_2(newForex.getAdd_line_2());
		originalFrx.setAdd_line_3(newForex.getAdd_line_3());
		
		originalFrx.setPassport_num(newForex.getPassport_num());
		originalFrx.setPassport_iss_dt(newForex.getPassport_iss_dt());
		originalFrx.setPassport_exp_dt(newForex.getPassport_exp_dt());
		originalFrx.setCity(newForex.getCity());
		originalFrx.setUid(newForex.getUid());
		
		originalFrx.setRequest_type(newForex.getRequest_type());
		originalFrx.setComments(newForex.getComments());
	}

	@Override
	public void createPDF(Forex forex, String fileName, String templateNm) 
	{
		if("STS_05".equals(forex.getStatus()))
		{
			Map dic = new HashMap();
			dic.put("forex", forex);
			dic.put("title", "Forex Request PDF");
			try 
			{
				pdfGenaratorUtil.createAndSavePdf(templateNm, dic, fileName, forex.getForex_id());
				emailService.sendSimpleMessage("sapna.m@misys.com", "FINTravex Test", "Test mail");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	@Override
	public List<Forex> getAllApprovedForexReports(String email) 
	{
		Employee emp = employeeRepository.getEmployeeByEmail(email);
		String status = "STS_05";
		if("FINANCE".equals(emp.getEmp_role()))
		{
			return forexRepository.findAllApprovedForexForFinance(status);
		}
		else
		{
			return forexRepository.findAllApprovedForexForEmp(email, status);
		}
	}

}
