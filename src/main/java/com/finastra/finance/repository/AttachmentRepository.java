package com.finastra.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finastra.finance.model.Attachments;

@Repository ("attachmentRepository")
public interface AttachmentRepository extends JpaRepository<Attachments, Integer>
{
	@Query("From attachments a where a.forex_id=:id")
	public Attachments getForexReport(@Param("id") int id);
}
