package com.finastra.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.finance.model.Forex;
import com.finastra.finance.repository.ForexRepository;

@Service
public class ForexServiceImpl implements ForexService
{
	@Autowired
	private ForexRepository forexRepository;
	
	@Override
	public void save(Forex forex) 
	{
		forexRepository.save(forex);		
	}

	@Override
	public List<Forex> getAllForexItemsByUser(String email) 
	{
		return forexRepository.findAllByUserId(email);
	}

}
