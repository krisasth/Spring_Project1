package com.brdway.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brdway.springbootmvc.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String un, String psw);

}
