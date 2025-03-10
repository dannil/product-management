package com.github.dannil.productmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dannil.productmanagement.model.database.Product;
import com.github.dannil.productmanagement.model.dto.AddProductDto;
import com.github.dannil.productmanagement.model.dto.ProductDto;
import com.github.dannil.productmanagement.service.ProductService;
import com.github.dannil.productmanagement.view.ViewType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ProductDto>> getAll(@RequestParam(required = false) String viewType) {
        ViewType viewTypeEnum = ViewType.ofWithFallback(viewType, ViewType.NORMAL);
        Stream<Product> products = productService.findAll().stream();
        List<ProductDto> dtos = switch (viewTypeEnum) {
            case ViewType.NORMAL -> products.map(Product::toNormalView).toList();
            case ViewType.FLAT -> products.map(Product::toFlatView).toList();
        };
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get().toNormalView());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<ProductDto> add(@RequestBody AddProductDto product) {
        Product dbProduct = productService.add(product);
        return ResponseEntity.ok(dbProduct.toNormalView());
    }

}
