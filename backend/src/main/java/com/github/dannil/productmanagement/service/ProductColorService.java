package com.github.dannil.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dannil.productmanagement.model.database.ProductColor;
import com.github.dannil.productmanagement.repository.ProductColorRepository;

@Service
public class ProductColorService {

    private final ProductColorRepository productColorRepository;

    public ProductColorService(ProductColorRepository productColorRepository) {
        this.productColorRepository = productColorRepository;
    }

    public List<ProductColor> findAll() {
        return productColorRepository.findAll();
    }

}
