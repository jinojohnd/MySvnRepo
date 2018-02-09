package com.finastra.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.finance.model.CountryCur;
import com.finastra.finance.repository.CountryCurRepository;

@Service
public class CountryCurImpl implements CountryCurService
{
	@Autowired
	CountryCurRepository countryCurRepo;
	
	@Override
	public List<CountryCur> getCountryCurLst() 
	{
		return countryCurRepo.findAll();
	}

}
