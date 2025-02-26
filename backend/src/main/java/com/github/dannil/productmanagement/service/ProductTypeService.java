package com.github.dannil.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dannil.productmanagement.model.database.ProductType;
import com.github.dannil.productmanagement.repository.ProductTypeRepository;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

}
