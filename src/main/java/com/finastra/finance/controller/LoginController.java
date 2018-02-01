package com.finastra.finance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finastra.finance.model.Forex;
import com.finastra.finance.model.Itinerary;
import com.finastra.finance.model.User;
import com.finastra.finance.service.ForexService;
import com.finastra.finance.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ForexService forexService;

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
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/forex-submission", method = RequestMethod.POST)
	public ModelAndView createNewForexRequest(@Valid Forex forex, @Valid Itinerary itinerary, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		getUserName(modelAndView);
		if (bindingResult.hasErrors()) 
		{			
			modelAndView.setViewName("forex_request");
		} 
		else
		{			
			forex.addItinerary(itinerary);
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
		if (bindingResult.hasErrors()) {
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
		getUserName(modelAndView);
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("home");
		return modelAndView;
	}

	private void getUserName(ModelAndView modelAndView) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
	}
	

}
