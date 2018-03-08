package com.finastra.finance.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.finastra.finance.model.Forex;
import com.finastra.finance.model.ForexDetails;
import com.finastra.finance.model.Itinerary;
import com.finastra.finance.service.CountryCurService;
import com.finastra.finance.service.EmployeeService;
import com.finastra.finance.service.ForexService;
import com.finastra.finance.service.UserService;
import com.finastra.finance.util.Utils;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ForexService forexService;
	
	@Autowired
	private CountryCurService countryCurService;
	
	@Autowired
	private EmployeeService employeeService;
	
	private Log LOG = LogFactory.getLog(LoginController.class);

	@RequestMapping(value= {"/","/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="home/create-forex", method = RequestMethod.GET)
	public ModelAndView createForexReq(){
		LOG.info("Inside the Create Forex");
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Forex frx = new Forex();
		forexService.setInitialData(frx, auth.getName());
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("forex_request");
		modelAndView.addObject("forex", frx);
		modelAndView.addObject("newList", true);
		modelAndView.addObject("fId", 0);
		modelAndView.addObject("itrSize", 0);
		modelAndView.addObject("countryCur", countryCurService.getCountryCurLst());
		return modelAndView;
	}
	
	@RequestMapping(value="home/create-forex", method = RequestMethod.GET, params = "id")
	public ModelAndView createForexReqFromExisting(@RequestParam("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		
		Forex frx = forexService.getForex(id);
		modelAndView.addObject("fId", id);
		modelAndView.addObject("itrSize", frx.getItineraryLst().size());
		modelAndView.setViewName("forex_request");
		modelAndView.addObject("forex", frx);
		modelAndView.addObject("countryCur", countryCurService.getCountryCurLst());
		return modelAndView;
	}
	
	@RequestMapping(value="home/pending-approval", method = RequestMethod.GET)
	public ModelAndView viewPendingApproval(){
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("list_pending_forex");
		return modelAndView;
	}
	
	@RequestMapping(value="home/forex-reports", method = RequestMethod.GET)
	public ModelAndView viewForexReports(){
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("list_forex_reports");
		return modelAndView;
	}
	
	@RequestMapping(value="home/approve/approve-forex", method = RequestMethod.GET, params = "id")
	public ModelAndView openForexForApproval(@RequestParam("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("open_approve_forex");
		modelAndView.addObject("fId", id);
		return modelAndView;
	}
	
	@RequestMapping(value="home/approve/submit-approval", method = RequestMethod.POST)
	public ModelAndView submitForexApproval(Forex forex, @RequestParam("id") int id,
			@RequestParam(value="action", required=true) String action){
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		forexService.approveForex(id, action);
		modelAndView.setViewName("success");
		if("approve".equals(action))
		{
			modelAndView.addObject("successMessage","Sucessfully Approved the Forex Request Form.");
		}
		else
		{
			modelAndView.addObject("successMessage","Sucessfully Rejected the Forex Request Form.");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/forex-submission", method = RequestMethod.POST)
	public ModelAndView submitForexRequest(@Valid Forex forex, @RequestParam("id") int id, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		
		if (bindingResult.hasErrors()) 
		{			
			modelAndView.setViewName("forex_request");
		}
		else
		{
			for(Itinerary itr:forex.getItineraryLst())
			{
				if(itr.getDeparture_dt()!=null || itr.getReturn_dt() !=null)
				{
					forex.addItinerary(itr);
				}
			}
			for(ForexDetails fDtls:forex.getForexDetailsLst())
			{
				forex.addForexDetails(fDtls);
			}
			
			preSubmitAction(forex);
			if(id == 0)
			{
				
				forexService.save(forex);
				modelAndView.setViewName("success");
				modelAndView.addObject("successMessage","Sucessfully submitted the Forex Request Form.");
			}
			else
			{
				forexService.updateForex(forex,id, "");
				modelAndView.setViewName("success");
				modelAndView.addObject("successMessage","Sucessfully Re-submitted the Forex Request Form.");
			}		
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value= "/home", method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utils.getUserName(modelAndView, userService);
		modelAndView.addObject("forexLst",forexService.getAllForexReqByUserId(auth.getName()));
		modelAndView.addObject("canApprove", employeeService.canApprove(auth.getName()));
		modelAndView.setViewName("home");
		return modelAndView;
	}

	private void preSubmitAction(Forex forex) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		forex.setInput_user_mail(auth.getName());
		forex.setStatus("STS_01");
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		try 
		{
			Date date = df.parse(reportDate);
			forex.setCreation_dt(date);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
	}

}
