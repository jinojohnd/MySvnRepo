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
	@Query("Select f.forex_id, f.emp_nm, f.emp_type, f.manager_nm from forex f where f.input_user_mail=:email")
	public List<Forex> findAllByUserId(@Param("email") String email);
	
	@Query("From forex f where f.email=:email")
	public List<Forex> findAllForexReqByUserId(@Param("email") String email);
	
	@Query("Select f.forex_id, f.emp_nm, f.emp_type, f.creation_dt from forex f, employee e where e.email = f.email and (e.manager_id =:id and f.status IN :statuses)")
	public List<Forex> findAllForexPendingFromManager(@Param("id") String id, @Param("statuses") List<String> forexSts);

	@Query("Select f.forex_id, f.emp_nm, f.emp_type, f.creation_dt from forex f, employee e where e.email = f.email and (e.manager_id =:id or f.status IN :statuses)")
	public List<Forex> findAllForexPendingFromFinance(@Param("id") String id, @Param("statuses") List<String> forexSts);
	
	@Query("Select f.forex_id, f.emp_nm, f.emp_type, f.creation_dt, a.file_name from forex f, attachments a where a.forex_id = f.forex_id and f.input_user_mail=:email and f.status=:status")
	public List<Forex> findAllApprovedForexForEmp(@Param("email") String email, @Param("status") String status);
	
	@Query("Select f.forex_id, f.emp_nm, f.emp_type, f.creation_dt, a.file_name from forex f, attachments a where a.forex_id = f.forex_id and f.status=:status")
	public List<Forex> findAllApprovedForexForFinance(@Param("status") String status);
}
