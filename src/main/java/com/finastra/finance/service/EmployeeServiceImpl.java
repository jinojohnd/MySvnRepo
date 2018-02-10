package com.finastra.finance.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.finance.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired EmployeeRepository employeeRepository;
	
	@Override
	public boolean canApprove(String email) 
	{
		boolean canApprove = false;
		String empDept = employeeRepository.getEmployeeRole(email);
		if(StringUtils.isNotEmpty(empDept))
		{
			canApprove = true;
		}			
		return canApprove;
	}

}
