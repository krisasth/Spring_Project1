package com.brdway.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brdway.springbootmvc.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
