package com.finastra.finance.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.finastra.finance.model.User;
import com.finastra.finance.service.UserService;

public class Utils 
{
	public static void getUserName(ModelAndView modelAndView, UserService userService) 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
	}
}
