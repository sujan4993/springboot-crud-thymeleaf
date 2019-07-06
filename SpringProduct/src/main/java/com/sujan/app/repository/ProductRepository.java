package com.sujan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sujan.app.entity.Product;

public interface ProductRepository 
                 extends JpaRepository<Product,Long>{

}
