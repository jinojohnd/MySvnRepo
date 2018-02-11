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
	
	@RequestMapping(value="home/forexEntriesForApproval", method = RequestMethod.GET)
	public List<Forex> getAllForexEntriesForApproval()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return forexService.getAllForexForApproval(auth.getName());
	}
	
	@RequestMapping(value="home/view-forex", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView viewForexReq(@RequestParam("id") int id, @RequestParam("operation") String operation)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view_forex");
		modelAndView.addObject("forex",forexService.getForex(id));
		return modelAndView;
	}
	
	@RequestMapping(value="home/approve/view-forex", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView openForexForApprove(@RequestParam("id") int id, @RequestParam("operation") String operation)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view_forex");
		modelAndView.addObject("forex",forexService.getForex(id));
		return modelAndView;
	}
}
