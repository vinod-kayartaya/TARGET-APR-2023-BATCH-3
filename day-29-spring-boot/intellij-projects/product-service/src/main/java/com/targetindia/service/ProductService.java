package com.targetindia.service;

import com.targetindia.entity.Product;
import com.targetindia.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getOneProduct(Integer productId){
        Optional<Product> result = repo.findById(productId);
        return result.isEmpty() ? null: result.get();
    }
}
