package com.finastra.finance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finastra.finance.model.Employee;

public interface EmployeeService 
{
	public boolean canApprove(String email);
	
	public String getEmpRole(String email);
	
	public List<Employee> findAll();
}
