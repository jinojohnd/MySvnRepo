package com.finastra.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finastra.finance.model.ForexDetails;

@Repository
public interface ForexDetailsRepository extends JpaRepository<ForexDetails, Integer>
{
	@Query("From forexDetails f where f.forex.forex_id=:forexId")
	public List<ForexDetails> getForexDetailsLst(@Param("forexId") int forexId);
}
