package com.github.dannil.productmanagement.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private Long id;
    private String name;
    private ProductTypeDto type;
    private List<ProductColorDto> colors;

    public ProductDto(Long id, String name, ProductTypeDto type, List<ProductColorDto> colors) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.colors = colors;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductTypeDto getType() {
        return type;
    }

    public void setType(ProductTypeDto type) {
        this.type = type;
    }

    public List<ProductColorDto> getColors() {
        return colors;
    }

    public void setColors(List<ProductColorDto> colors) {
        this.colors = colors;
    }

}
