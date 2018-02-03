package com.finastra.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finastra.finance.model.Forex;
import com.finastra.finance.model.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Forex,Integer>
{
	@Query("From itinerary i where i.forex.forex_id=:forexId")
	public List<Itinerary> getItineraryLst(@Param("forexId") int forexId);
}
