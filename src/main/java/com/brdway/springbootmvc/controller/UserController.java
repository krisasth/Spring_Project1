package com.brdway.springbootmvc.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brdway.springbootmvc.model.User;
import com.brdway.springbootmvc.repository.ProductRepository;
import com.brdway.springbootmvc.service.UserService;
import com.brdway.springbootmvc.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;

//@Slf4j (if we have lombook we use this only as lombok is anotation .private final Logger log = LoggerFactory.getLogger(UserController.class);)
@Controller
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);//to make logfiles
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("prodList",prodRepo.findAll());
		return"CustomerHome";
	}
	@GetMapping("/login")//multiple url pattern
	public String getLogin() {
		return"Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User u, Model model, HttpSession session,@RequestParam("g-recaptcha-response") String gCode) throws IOException {
		
		if(VerifyRecaptcha.verify(gCode)) {
	
			log.info("----user loginpage---");
			
			User usr= userservice.login(u.getUsername(), u.getPassword());
			if(usr !=null) {
				log.info("-----Login success----");
				
				session.setAttribute("activeuser", usr);
				session.setMaxInactiveInterval(500);
				
				if(usr.getRole().equals("Customer")) {
					model.addAttribute("prodList",prodRepo.findAll());
					return "CustomerHome";
				}
				return "Home";
			}
			else {

				log.info("----login failed");
				model.addAttribute("error","user not found!");
				return"Login";
			}
		}
		

		else {
			model.addAttribute("error","You are robot");
			return"Login";
		}
	
	}
	@GetMapping("/signup")
	public String getSignup() {
		return"Signup";
	}

	
	@PostMapping("/signup")
	public String postsignup(@ModelAttribute User u) {
		 
		//TODO check user if already exist
		
		userservice.signup(u);
		
		return"Login";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();//session kill
		return"Login";
	}
	
	@GetMapping("/profile")
	public String getprofile() {
		return"Profile";
	}
}
