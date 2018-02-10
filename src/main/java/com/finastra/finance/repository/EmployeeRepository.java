package com.finastra.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finastra.finance.model.Employee;

@Repository ("employeeRepository")
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	@Query("From employee e where e.email=:email")
	public Employee getEmployeeByEmail(@Param("email") String email);
	
	@Query("Select e.emp_role from employee e where e.email=:email")
	public String getEmployeeRole(@Param("email") String email);
}
