package com.github.dannil.productmanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dannil.productmanagement.model.database.ProductType;
import com.github.dannil.productmanagement.model.dto.ProductTypeDto;
import com.github.dannil.productmanagement.service.ProductTypeService;

@RestController
@RequestMapping("/types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ProductTypeDto>> getAll() {
        List<ProductTypeDto> dtos = productTypeService.findAll().stream().map(ProductType::toNormalView).toList();
        return ResponseEntity.ok(dtos);
    }

}
