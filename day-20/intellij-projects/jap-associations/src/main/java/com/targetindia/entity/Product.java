package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product {
    @Id
    @Column(name="product_id")
    private Integer productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="quantity_per_unit")
    private String quantityPerUnit;
    @Column(name="supplier_id")
    private Integer supplierId;
    @Column(name="unit_price")
    private Double unitPrice;
    @Column(name="units_in_stock")
    private Integer unitsInStock;
    @Column(name="units_on_order")
    private Integer unitsOnOrder;
    @Column(name="reorder_level")
    private Integer reorderLevel;
    private Integer discontinued;

    // many products belong to one category
    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name="category_id") // when @JoinColumn is used, the name of the column is picked from the current table
    private Category category;
}
