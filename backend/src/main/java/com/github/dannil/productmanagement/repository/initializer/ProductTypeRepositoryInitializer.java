package com.github.dannil.productmanagement.repository.initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.github.dannil.productmanagement.model.database.ProductType;
import com.github.dannil.productmanagement.repository.ProductTypeRepository;

import jakarta.annotation.PostConstruct;

@Repository
public class ProductTypeRepositoryInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeRepositoryInitializer.class);

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeRepositoryInitializer(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @PostConstruct
    public void init() {
        for (ProductType.Type type : ProductType.Type.values()) {
            ProductType dbType = productTypeRepository.findByType(type);
            if (dbType == null) {
                productTypeRepository.save(new ProductType(type));
                LOGGER.info("Added " + type.toString() + " to database");
            }
        }
    }

}
