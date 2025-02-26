package com.github.dannil.productmanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dannil.productmanagement.model.database.ProductColor;
import com.github.dannil.productmanagement.model.dto.ProductColorDto;
import com.github.dannil.productmanagement.service.ProductColorService;

@RestController
@RequestMapping("/colors")
public class ProductColorController {

    private final ProductColorService productColorService;

    public ProductColorController(ProductColorService productColorService) {
        this.productColorService = productColorService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ProductColorDto>> getAll() {
        List<ProductColorDto> dtos = productColorService.findAll().stream().map(ProductColor::toNormalView).toList();
        return ResponseEntity.ok(dtos);
    }

}
