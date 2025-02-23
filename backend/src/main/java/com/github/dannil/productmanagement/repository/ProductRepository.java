package com.github.dannil.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dannil.productmanagement.model.database.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
