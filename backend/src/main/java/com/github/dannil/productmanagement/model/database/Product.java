package com.github.dannil.productmanagement.model.database;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.List;
import java.util.Set;

import com.github.dannil.productmanagement.model.dto.ProductColorDto;
import com.github.dannil.productmanagement.model.dto.ProductDto;
import com.github.dannil.productmanagement.view.View;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Product implements View<ProductDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private ZonedDateTime created;

    @ManyToOne
    @JoinColumn(name = "type")
    private ProductType type;

    @ManyToMany
    @JoinTable(name = "product_color_products", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "color_id", referencedColumnName = "id"))
    private Set<ProductColor> colors;

    public Product() {
        this.created = ZonedDateTime.now();
        this.colors = new HashSet<>();
    }

    public Product(String name, ProductType type, Set<ProductColor> colors) {
        this();
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

    public ZonedDateTime getCreated() {
        return created;
    }

    public ProductType getType() {
        return type;
    }

    public Set<ProductColor> getColors() {
        return colors;
    }

    public void addColor(ProductColor color) {
        colors.add(color);
    }

    @Override
    public ProductDto toNormalView() {
        List<ProductColorDto> dtos = colors.stream().map(ProductColor::toNormalView).toList();
        return new ProductDto(id, name, type.toNormalView(), dtos);
    }

    @Override
    public ProductDto toFlatView() {
        ProductDto dto = toNormalView();
        dto.setColors(null);
        dto.setType(null);
        return dto;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(name, other.name) && Objects.equals(created, other.created)
                && Objects.equals(type, other.type);
    }

    @Override
    public int hashCode() {
        return 37 * name.hashCode() * created.hashCode() * type.hashCode();
    }

}
