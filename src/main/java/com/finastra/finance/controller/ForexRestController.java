package com.finastra.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.finastra.finance.model.Attachments;
import com.finastra.finance.model.Forex;
import com.finastra.finance.service.AttachmentService;
import com.finastra.finance.service.EmployeeService;
import com.finastra.finance.service.ForexService;

@RestController
public class ForexRestController 
{
	@Autowired
	private ForexService forexService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AttachmentService attachmentService;
	
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
	
	@RequestMapping(value="home/forexApprovedList", method = RequestMethod.GET)
	public List<Forex> getAllApprovedForexReports()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return forexService.getAllApprovedForexReports(auth.getName());
	}
	
	@RequestMapping(value="home/download-report", method = RequestMethod.GET)
	public HttpEntity<byte[]>  downloadForexReport(@RequestParam("id") int id)
	{
		Attachments forexReport = attachmentService.getForexReport(id);
		byte[] document = forexReport.getFile_content();
		HttpHeaders header = new HttpHeaders();
	    header.setContentType(new MediaType("application", "pdf"));
	    header.set("Content-Disposition", "attachment; filename=" + forexReport.getFile_name()+forexReport.getFile_type());
	    header.setContentLength(document.length);
	    return new HttpEntity<byte[]>(document, header);
	}
	
	@RequestMapping(value="home/view-forex", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView viewForexReq(@RequestParam("id") int id, @RequestParam("operation") String operation)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view_forex");
		modelAndView.addObject("forex",forexService.getForex(id));
		modelAndView.addObject("empRole", getEmployeeType());
		return modelAndView;
	}
	
	@RequestMapping(value="home/approve/view-forex", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView openForexForApprove(@RequestParam("id") int id, @RequestParam("operation") String operation)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view_forex");
		modelAndView.addObject("forex",forexService.getForex(id));
		modelAndView.addObject("empRole", getEmployeeType());
		return modelAndView;
	}
	
	public String getEmployeeType()
	{
		String type = "";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		type = employeeService.getEmpRole(auth.getName());		
		return type;
	}
}
