package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column
    private String description;
    @Column
    private byte[] picture;

    // one category has many products
    @OneToMany // (fetch = FetchType.EAGER) // for one-to-many, the fetch type is Lazy by default
    @JoinColumn(name = "category_id")
    // When you use @OneToMany, the join column is picked as the foreign key in the referenced table
    private List<Product> productList;
}
