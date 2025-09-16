package com.brdway.springbootmvc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toemail, String subject,String message) {
		
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setTo(toemail);
	mail.setSubject(subject);
	mail.setText(message);
	mailSender.send(mail);
	}
	
}
