package com.github.dannil.productmanagement.model.dto;

public class AddProductDto {

    private String name;
    private Long type;
    private Long color;

    public AddProductDto(String name, Long type, Long color) {
        this.name = name;
        this.type = type;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Long getType() {
        return type;
    }

    public Long getColor() {
        return color;
    }

}
