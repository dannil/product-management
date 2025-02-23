package com.github.dannil.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dannil.productmanagement.model.database.ProductColor;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {

    ProductColor findByColor(ProductColor.Color color);

}
