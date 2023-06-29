package com.targetindia.controllers;

import com.targetindia.entity.Product;
import com.targetindia.model.AppInfo;
import com.targetindia.model.CustomResponse;
import com.targetindia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(path="/info", produces = {"application/json", "application/xml"})
    public AppInfo getInfoAsJson(){
        return new AppInfo("Product Service", "1.0.0", "Vinod", "vinod@vinod.co");
    }

    @GetMapping(path = "/info", produces = "text/plain")
    public String getInfo(){
        return "Name: Product Service\n" +
                "Version: 1.0.0\n" +
                "Author: Vinod Kumar K\n" +
                "Email: vinod@vinod.co\n";
    }

    @GetMapping(produces = {"application/json", "application/xml"})
    public List<Product> handleGetAllAsJson(){
        return service.getAllProducts();
    }

    @GetMapping(path="/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetOneAsJson(@PathVariable("id") Integer productId){
        Product p1 = service.getOneProduct(productId);
        if(p1==null){
            CustomResponse cr = new CustomResponse("No data found for id " + productId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cr);
        }

        return ResponseEntity.ok(p1);
    }
}
