package com.github.dannil.productmanagement.repository.initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.github.dannil.productmanagement.model.database.ProductColor;
import com.github.dannil.productmanagement.repository.ProductColorRepository;

import jakarta.annotation.PostConstruct;

@Component
public class ProductColorRepositoryInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductColorRepositoryInitializer.class);

    private final ProductColorRepository productColorRepository;

    public ProductColorRepositoryInitializer(ProductColorRepository productColorRepository) {
        this.productColorRepository = productColorRepository;
    }

    @PostConstruct
    public void init() {
        for (ProductColor.Color color : ProductColor.Color.values()) {
            ProductColor dbColor = productColorRepository.findByColor(color);
            if (dbColor == null) {
                productColorRepository.save(new ProductColor(color, null));
                LOGGER.info("Added " + color.toString() + " to database");
            }
        }
    }

}
