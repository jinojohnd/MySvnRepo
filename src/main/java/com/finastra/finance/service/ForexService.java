package com.finastra.finance.service;

import java.util.List;

import com.finastra.finance.model.Forex;

public interface ForexService 
{
	public void save(Forex forex);
	
	public List<Forex> getAllForexItemsByUser(String email);
	
	public List<Forex> getAllForexReqByUserId(String email);
	
	public Forex getForex(int id);
}
