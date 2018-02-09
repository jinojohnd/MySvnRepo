package com.finastra.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finastra.finance.model.CountryCur;

@Repository ("countryCurRepository")
public interface CountryCurRepository extends JpaRepository<CountryCur,Integer>
{

}
