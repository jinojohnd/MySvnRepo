package com.finastra.finance.service;

import java.util.List;

import com.finastra.finance.model.Holiday;

public interface HolidayService 
{
	public List<Holiday> findAll();
	public Holiday getHolidayById(Integer id);
    public Holiday create(Holiday holiday);
    public void update(Holiday holiday);
    public void deleteById(int id);
}
