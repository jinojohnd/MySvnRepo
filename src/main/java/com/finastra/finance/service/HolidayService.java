package com.finastra.finance.service;

import java.util.List;

import com.finastra.finance.model.Holiday;

public interface HolidayService 
{
	public List<Holiday> findAll();
	public Holiday getHolidayById(Integer id);
    public Holiday create(Holiday post);
    public void update(Holiday post);
    public void deleteById(int id);
}
