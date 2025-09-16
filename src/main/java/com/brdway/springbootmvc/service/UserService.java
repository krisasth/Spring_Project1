package com.brdway.springbootmvc.service;

import com.brdway.springbootmvc.model.User;

public interface UserService {
 void signup(User u);
 
User login(String un, String psw);
}
