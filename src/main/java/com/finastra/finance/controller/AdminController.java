package com.finastra.finance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.finastra.finance.model.Holiday;
import com.finastra.finance.service.EmployeeService;
import com.finastra.finance.service.HolidayService;
import com.finastra.finance.service.RoleService;
import com.finastra.finance.service.UserService;
import com.finastra.finance.util.Utils;

@Controller
public class AdminController 
{
	@Autowired
	private HolidayService holidayService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value= "/admin", method = RequestMethod.GET)
	public ModelAndView getAdministrationModule()
	{
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("admin");
		return modelAndView;
	}
	
	
	@RequestMapping(value= "/admin/holiday-list", method = RequestMethod.GET)
	public ModelAndView getHolidayList()
	{
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("holiday");
		modelAndView.addObject("holiday", holidayService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value= "/admin/view-holiday", method = RequestMethod.GET)
	public ModelAndView editHolidayDtls(@RequestParam("id") int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("holidayEdit");
		modelAndView.addObject("holiday", holidayService.getHolidayById(id));
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	@RequestMapping(value= "/admin/update-holiday", method = RequestMethod.POST)
	public ModelAndView updateHolidayDtls(@Valid Holiday holiday)
	{
		holidayService.update(holiday);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("holiday");
		modelAndView.addObject("holiday", holidayService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value= "/admin/view-delete-holiday", method = RequestMethod.GET)
	public ModelAndView deleteHolidayPopup(@RequestParam("id") int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("holidayDelete");
		modelAndView.addObject("holiday", holidayService.getHolidayById(id));
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	@RequestMapping(value= "/admin/delete-holiday", method = RequestMethod.POST)
	public ModelAndView deleteHoliday(@RequestParam("holiday_id") int id)
	{
		holidayService.deleteById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("holiday");
		modelAndView.addObject("holiday", holidayService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value= "/admin/view-add-holiday", method = RequestMethod.GET)
	public ModelAndView addHolidayPopup()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("holiday", new Holiday());
		modelAndView.setViewName("holidayAdd");
		return modelAndView;
	}
	
	@RequestMapping(value= "/admin/save-holiday", method = RequestMethod.POST)
	public ModelAndView saveHoliday(@Valid Holiday holiday)
	{
		holidayService.create(holiday);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("holiday");
		modelAndView.addObject("holiday", holidayService.findAll());
		return modelAndView;
	}
	

	@RequestMapping(value= "/admin/emp-list", method = RequestMethod.GET)
	public ModelAndView viewEmployeeDtls()
	{
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("employee-list");
		modelAndView.addObject("employee", employeeService.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value= "/admin/role-list", method = RequestMethod.GET)
	public ModelAndView viewRoleDtls()
	{
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("role");
		modelAndView.addObject("role", roleService.findAll());
		return modelAndView;
	}
}
