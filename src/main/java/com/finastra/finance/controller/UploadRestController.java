package com.finastra.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finastra.finance.model.Forex;
import com.finastra.finance.service.ForexService;

@RestController
public class UploadRestController 
{
	@Autowired
	private ForexService forexService;
	
	@RequestMapping(value="upload/forexReportForUpload", method = RequestMethod.GET)
	public List<Forex> getAllApprovedForexForCentrumBillUpload()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return forexService.getAllApprovedForexReports(auth.getName());
	}
}
