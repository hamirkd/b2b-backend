package com.b2b.b2b.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	
	@Autowired
    public JavaMailSender emailSender;
	
	 public String sendSimpleEmail(String email,String subject,String messageText) {
		 
	        // Create a Simple MailMessage./*
//	        SimpleMailMessage message = new SimpleMailMessage();
//	        message.setTo(email);
//	        message.setSubject(subject);
//	        message.setText(messageText);
	 
	        // Send Message!
//	        this.emailSender.send(message);
	 
	        return "Email Sent!";
	    }
}
