package com.finastra.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.finance.model.Holiday;
import com.finastra.finance.repository.HolidayRepository;

@Service
public class HolidayServiceImpl implements HolidayService
{
	@Autowired 
	HolidayRepository holidayRepository;
	
	public void setHolidayRepository(HolidayRepository holidayRepository) {
	    this.holidayRepository = holidayRepository;
	}

	@Override
	public List<Holiday> findAll() {
		return holidayRepository.findAll();
	}
	
	public Holiday getHolidayById(Integer id) {
	    return holidayRepository.findOne(id);
	}

	@Override
	public Holiday create(Holiday holiday) {
		// TODO Auto-generated method stub
		return holidayRepository.save(holiday);
	}

	@Override
	public void update(Holiday holiday) {		
		holidayRepository.findOne(holiday.getHoliday_id());
		holidayRepository.saveAndFlush(holiday);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		 holidayRepository.delete(id);
	}
	
	

}
