package com.finastra.finance.service;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService
{
	 @Autowired
	 private JavaMailSender emailSender;
	 
	 @Value("${spring.mail.from}")
	 private String from;
	 
	 @Value("${spring.mail.name}")
	 private String name;

	@Async
	@Override
	public void sendSimpleMessage(String to, String subject, String text) 
	{
		try 
		{
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setFrom(from);
			helper.setValidateAddresses(true);
		    helper.setSubject(subject);
		    helper.setText(text);
		    emailSender.send(message);
	     } 
		 catch (MessagingException exception) 
		 {
	        exception.printStackTrace();
	     }	
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, File file) 
	{
		try 
		{
			MimeMessage message = emailSender.createMimeMessage();
	        // pass 'true' to the constructor to create a multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(text);	
	        helper.setFrom(from, name);
	        
	        helper.addAttachment(file.getName()+".pdf", file);
	        emailSender.send(message);
	        
	        System.out.println("Email with Attachement is sent sucessfully");
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
	}	
}
