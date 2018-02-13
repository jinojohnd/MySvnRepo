package com.finastra.finance.service;

import java.io.File;

public interface EmailService 
{
	public void sendSimpleMessage(String to,  String subject, String text);	
	
	 public void sendMessageWithAttachment(String to, String subject, String text, File file);
}
