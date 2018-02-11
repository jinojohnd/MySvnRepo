package com.finastra.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.finance.model.Holiday;

@Repository ("holidayRepository")
public interface HolidayRepository  extends JpaRepository<Holiday, Integer>{
	
}
