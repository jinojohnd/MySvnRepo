package com.finastra.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.finastra.finance.model.Forex;
import com.finastra.finance.service.ForexService;

@RestController
public class ForexRestController 
{
	@Autowired
	private ForexService forexService;
	
	@RequestMapping(value="/home/forexEntries", method = RequestMethod.GET)
	public List<Forex> getAllForexEntriesByUserId()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return forexService.getAllForexItemsByUser(auth.getName());
	}
	
	/*@RequestMapping(value="home/view-forex", method = RequestMethod.GET)
	public String viewForexReq(@RequestParam("id") int id)
	{
		return forexService.getForex(id).toJson();
	}*/
	
	@RequestMapping(value="home/view-forex", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView viewForexReq(@RequestParam("id") int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view_forex");
		modelAndView.addObject("forex",forexService.getForex(id));
		return modelAndView;
	}
}
