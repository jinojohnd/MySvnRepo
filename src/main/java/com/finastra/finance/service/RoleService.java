package com.finastra.finance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.finastra.finance.model.Employee;
import com.finastra.finance.model.Holiday;
import com.finastra.finance.model.Role;

public interface RoleService 
{
	public List<Role> findAll();
}
