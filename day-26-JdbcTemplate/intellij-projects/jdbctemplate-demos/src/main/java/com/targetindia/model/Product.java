package com.targetindia.model;

import lombok.Data;

@Data
public class Product {
    private Integer productId;
    private String productName;
    private Integer categoryId;
    private Integer supplierId;
    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Integer discontinued;
}

