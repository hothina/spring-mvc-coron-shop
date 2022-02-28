package com.cg.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="category_groups")
@Getter
@Setter
public class CategoryGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @OneToMany(mappedBy = "categoryGroup")
    private Set<Product> products;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public CategoryGroup() {
    }

    public CategoryGroup(Long id, String name, String slug, boolean deleted, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.deleted = deleted;
        this.products = products;
    }
}
