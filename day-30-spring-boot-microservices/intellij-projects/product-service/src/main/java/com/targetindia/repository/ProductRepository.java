package com.targetindia.repository;

import com.targetindia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("from Product where lower(productName) like concat('%', lower(?1), '%') ") // case-insensitive query
    public List<Product> findByProductName(String productName); // findByFieldNameInTheEntityClass
    // going to execute the Query --> from Product where productName = ?1

    public List<Product> findAllByCategoryId(Integer categoryId); // findAllByFieldNameInTheEntityClass

    public List<Product> findAllBySupplierId(Integer supplierId);

    public List<Product> findAllByDiscontinued(Integer integer);

    public List<Product> findAllByUnitsInStock(Integer integer);

    public List<Product> findAllByUnitPriceBetween(Double min, Double max); // from Product where unitPrice between ?1 and ?2
}
