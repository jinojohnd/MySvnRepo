package com.finastra.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finastra.finance.model.Attachments;
import com.finastra.finance.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService
{
	@Autowired
	AttachmentRepository attachmentRepository;

	@Override
	public Attachments getForexReport(int id) 
	{
		return attachmentRepository.getForexReport(id);
		
	}

}
