package com.finastra.finance.service;

import java.util.List;

import com.finastra.finance.model.Forex;

public interface ForexService 
{
	public void save(Forex forex);
	
	public List<Forex> getAllForexItemsByUser(String email);
	
	public List<Forex> getAllForexReqByUserId(String email);
	
	public Forex getForex(int id);

	public void setInitialData(Forex frx, String Email);
	
	public List<Forex> getAllForexForApproval(String email);
	
	public void approveForex(int id, String action);

	public void updateForex(Forex forex, int id, String string);
	
	public void completeForex(Forex oldForex, Forex newForex);
	
	public void createPDF(Forex forex, String fileName, String templateNm);
	
	public List<Forex> getAllApprovedForexReports(String email);
}
