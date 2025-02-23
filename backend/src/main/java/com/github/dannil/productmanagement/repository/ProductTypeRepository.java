package com.github.dannil.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dannil.productmanagement.model.database.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    ProductType findByType(ProductType.Type type);

}
