package com.finastra.finance.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

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
import com.finastra.finance.model.Itinerary;
import com.finastra.finance.model.User;
import com.finastra.finance.service.CountryCurService;
import com.finastra.finance.service.ForexService;
import com.finastra.finance.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ForexService forexService;
	
	@Autowired
	private CountryCurService countryCurService;

	@RequestMapping(value= {"/","/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value="home/create-forex", method = RequestMethod.GET)
	public ModelAndView createForexReq(){
		ModelAndView modelAndView = new ModelAndView();
		getUserName(modelAndView);
		modelAndView.setViewName("forex_request");
		modelAndView.addObject("forex", new Forex());
		modelAndView.addObject("countryCur", countryCurService.getCountryCurLst());
		return modelAndView;
	}
	
	@RequestMapping(value="home/create-forex", method = RequestMethod.GET,  params = "id")
	public ModelAndView createForexReqFromExisting(@RequestParam("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		getUserName(modelAndView);
		modelAndView.setViewName("forex_request");
		modelAndView.addObject("forex", forexService.getForex(id));
		modelAndView.addObject("countryCur", countryCurService.getCountryCurLst());
		return modelAndView;
	}
	
	@RequestMapping(value="home/list-forex", method = RequestMethod.GET)
	public ModelAndView createForexReqFromExisiting(){
		ModelAndView modelAndView = new ModelAndView();
		getUserName(modelAndView);
		modelAndView.setViewName("list_forex");
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/forex-submission", method = RequestMethod.POST)
	public ModelAndView submitNewForexRequest(@Valid Forex forex, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		getUserName(modelAndView);
		
		if (bindingResult.hasErrors()) 
		{			
			modelAndView.setViewName("forex_request");
		} 
		else
		{
			for(Itinerary itr:forex.getItineraryLst())
			{
				forex.addItinerary(itr);
			}
			
			preSubmitAction(forex);
			forexService.save(forex);
			modelAndView.setViewName("success");
			modelAndView.addObject("successMessage","Sucessfully submitted the Forex Request Form.");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (!bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value= "/home", method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		getUserName(modelAndView);
		modelAndView.addObject("forexLst",forexService.getAllForexReqByUserId(auth.getName()));
		modelAndView.setViewName("home");
		return modelAndView;
	}

	private void getUserName(ModelAndView modelAndView) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
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
