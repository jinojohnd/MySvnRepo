package com.finastra.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.finance.model.Role;
import com.finastra.finance.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService
{
	@Autowired RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
