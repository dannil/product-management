package com.github.dannil.productmanagement.model.database;

import java.util.Objects;

import com.github.dannil.productmanagement.model.dto.ProductTypeDto;
import com.github.dannil.productmanagement.view.View;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductType implements View<ProductTypeDto> {

    public enum Type {
        SOFA, CHAIR, TABLE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductType.Type type;

    public ProductType() {

    }

    public ProductType(ProductType.Type type) {
        this();
        this.type = type;
    }

    public ProductType.Type getType() {
        return type;
    }

    @Override
    public ProductTypeDto toNormalView() {
        return new ProductTypeDto(id, type.toString().toLowerCase());
    }

    @Override
    public ProductTypeDto toFlatView() {
        // No fields can be recursive; return the normal view
        return toNormalView();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductType)) {
            return false;
        }
        ProductType other = (ProductType) obj;
        return Objects.equals(type, other.type);
    }

    @Override
    public int hashCode() {
        return 37 * type.hashCode();
    }

}
