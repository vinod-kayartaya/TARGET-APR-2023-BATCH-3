package com.targetindia.model;

import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name="product")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class ProductDTO {
    private Integer productId;
    private String productName;
    private CategoryDTO category;
    private SupplierDTO supplier;
    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Integer discontinued;
}
