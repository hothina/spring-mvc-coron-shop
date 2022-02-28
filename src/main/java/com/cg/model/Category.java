package com.cg.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    @OneToMany(mappedBy = "category")
    private Set<CategoryGroup> categoryGroups;

    public Category() {
    }

    public Category(Long id, String name, String slug, boolean deleted, Set<CategoryGroup> categoryGroups) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.deleted = deleted;
        this.categoryGroups = categoryGroups;
    }
}
