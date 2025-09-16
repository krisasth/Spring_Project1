package com.brdway.springbootmvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brdway.springbootmvc.model.User;
import com.brdway.springbootmvc.repository.UserRepository;
import com.brdway.springbootmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
 @Autowired
	private UserRepository userrepo;
	@Override
	public void signup(User u) {
	userrepo.save(u);
		
	}

	@Override
	public User login(String un, String psw) {
	return userrepo.findByUsernameAndPassword(un, psw);
		
	}

}
