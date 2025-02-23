package com.github.dannil.productmanagement.repository.initializer;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.github.dannil.productmanagement.model.database.Product;
import com.github.dannil.productmanagement.model.database.ProductColor;
import com.github.dannil.productmanagement.model.database.ProductType;
import com.github.dannil.productmanagement.repository.ProductColorRepository;
import com.github.dannil.productmanagement.repository.ProductRepository;
import com.github.dannil.productmanagement.repository.ProductTypeRepository;

import jakarta.annotation.PostConstruct;

@DependsOn(value = { "productColorRepositoryInitializer", "productTypeRepositoryInitializer" })
@Component
public class ProductRepositoryInitializer {

    private final ProductRepository productRepository;
    private final ProductColorRepository productColorRepository;
    private final ProductTypeRepository productTypeRepository;

    public ProductRepositoryInitializer(ProductRepository productRepository,
            ProductColorRepository productColorRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productColorRepository = productColorRepository;
        this.productTypeRepository = productTypeRepository;
    }

    @PostConstruct
    public void init() {
        productRepository.deleteAll();

        // Add some default products so the frontend has something to show out-of-box
        ProductColor blue = productColorRepository.findByColor(ProductColor.Color.BLUE);
        ProductColor ruby = productColorRepository.findByColor(ProductColor.Color.RUBY);

        ProductType chair = productTypeRepository.findByType(ProductType.Type.CHAIR);
        ProductType sofa = productTypeRepository.findByType(ProductType.Type.SOFA);
        ProductType table = productTypeRepository.findByType(ProductType.Type.TABLE);

        Product alex = new Product("ALEX", table, new HashSet<>(List.of(blue, ruby)));
        productRepository.save(alex);

        Product stockholm = new Product("STOCKHOLM", chair, new HashSet<>(List.of(blue)));
        productRepository.save(stockholm);

        Product vimle = new Product("VIMLE", sofa, new HashSet<>(List.of(ruby)));
        productRepository.save(vimle);
    }

}
