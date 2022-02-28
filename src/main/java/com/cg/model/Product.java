package com.cg.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_group_id")
    private CategoryGroup categoryGroup;

    private String name;

    @Digits(integer = 9, fraction = 0)
    @Column(updatable = false)
    private BigDecimal price = BigDecimal.valueOf(0);

    private int quantity;

    private String avatar;

    @Lob
    private String description;

    private String slug;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, int quantity, String avatar, String description, String slug, boolean deleted) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.avatar = avatar;
        this.description = description;
        this.slug = slug;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryGroup getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(CategoryGroup categoryGroup) {
        this.categoryGroup = categoryGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
