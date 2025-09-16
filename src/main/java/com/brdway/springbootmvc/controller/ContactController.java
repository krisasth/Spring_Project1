package com.brdway.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brdway.springbootmvc.utils.MailUtils;

@Controller
public class ContactController {
 @Autowired
	private MailUtils mailutils;
	
	@GetMapping("/contact")
	public String getcontact() {
		return"ContactForm";
	}
	@PostMapping("/contact")
	public String postcontact(@RequestParam("toemail") String toemail,@RequestParam("subject") String subject,@RequestParam("message") String message) {
		 mailutils.sendEmail(toemail, subject, message);
		return"ContactForm";
	}
}
