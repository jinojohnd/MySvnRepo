package com.finastra.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finastra.finance.model.Forex;

@Repository ("forexRepository")
public interface ForexRepository  extends JpaRepository<Forex,Integer>
{
	//Note: the "From table_name" should be "From entity_name" where the name of the table is mapped to the entity
	@Query("Select f.emp_nm, f.emp_type, f.manager_nm, f.total_amt from forex f where f.email=:email")
	public List<Forex> findAllByUserId(@Param("email") String email);
}
