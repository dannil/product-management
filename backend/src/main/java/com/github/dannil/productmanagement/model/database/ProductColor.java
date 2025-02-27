package com.github.dannil.productmanagement.model.database;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.github.dannil.productmanagement.model.dto.ProductColorDto;
import com.github.dannil.productmanagement.view.View;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class ProductColor implements View<ProductColorDto> {

    public enum Color {
        BLUE, RUBY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToMany(mappedBy = "colors")
    private Set<Product> products;

    public ProductColor() {
        this.products = new HashSet<>();
    }

    public ProductColor(ProductColor.Color color, Set<Product> products) {
        this();
        this.color = color;
        this.products = products;
    }

    public Color getColor() {
        return color;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public ProductColorDto toNormalView() {
        return new ProductColorDto(id, color.toString().toLowerCase());
    }

    @Override
    public ProductColorDto toFlatView() {
        // No fields can be recursive; return the normal view
        return toNormalView();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductColor)) {
            return false;
        }
        ProductColor other = (ProductColor) obj;
        return Objects.equals(color, other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

}
