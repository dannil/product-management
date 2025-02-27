package com.github.dannil.productmanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.github.dannil.productmanagement.model.database.Product;
import com.github.dannil.productmanagement.model.database.ProductColor;
import com.github.dannil.productmanagement.model.database.ProductType;
import com.github.dannil.productmanagement.model.dto.AddProductDto;
import com.github.dannil.productmanagement.repository.ProductColorRepository;
import com.github.dannil.productmanagement.repository.ProductRepository;
import com.github.dannil.productmanagement.repository.ProductTypeRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final ProductColorRepository productColorRepository;

    public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository,
            ProductColorRepository productColorRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.productColorRepository = productColorRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAllByOrderByCreatedDesc();
    }

    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    public Product add(AddProductDto product) {
        Optional<ProductType> dbType = productTypeRepository.findById(product.getType());
        Optional<ProductColor> dbColor = productColorRepository.findById(product.getColor());
        Product dbProduct = new Product(product.getName(), dbType.get(), Set.of(dbColor.get()));
        return productRepository.save(dbProduct);
    }

}
