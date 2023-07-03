package com.targetindia.controllers;

import com.targetindia.entity.Product;
import com.targetindia.model.AppInfo;
import com.targetindia.model.CustomResponse;
import com.targetindia.model.ProductDTO;
import com.targetindia.model.ProductList;
import com.targetindia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(path = "/info", produces = {"application/json", "application/xml"})
    public AppInfo getInfoAsJson() {
        return new AppInfo("Product Service", "1.0.0", "Vinod", "vinod@vinod.co");
    }

    @GetMapping(path = "/info", produces = "text/plain")
    public String getInfo() {
        return "Name: Product Service\n" +
                "Version: 1.0.0\n" +
                "Author: Vinod Kumar K\n" +
                "Email: vinod@vinod.co\n";
    }

    @GetMapping(path = "/search", produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetSearch(
            @RequestParam("fieldName") String fieldName,
            @RequestParam("fieldValue") String fieldValue) {

        Object result = service.getProductsByField(fieldName, fieldValue);
        if(result==null){
            result = new CustomResponse("feature not implemented yet");
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "/by-price-range", produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetByPriceRange(
            @RequestParam(name="min", required = false) Double min,
            @RequestParam(name="max", required = false) Double max){

        if(min==null || max==null){
            CustomResponse cr = new CustomResponse("both parameters `min` and `max` are required");
            return ResponseEntity.status(400).body(cr);
        }

        ProductList result = service.getProductsByPriceRange(min, max);
        return ResponseEntity.ok(result);
    }


    @GetMapping(produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetAllAsJson(
            @RequestParam(name = "page", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "limit", defaultValue = "10") Integer pageSize) {

        return ResponseEntity.ok( service.getAllProducts(pageNum, pageSize));
    }

    @GetMapping(path = "/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetOneAsJson(@PathVariable("id") Integer productId) {
        ProductDTO p1 = service.getOneProduct(productId);
        if (p1 == null) {
            CustomResponse cr = new CustomResponse("No data found for id " + productId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cr);
        }

        return ResponseEntity.ok(p1);
    }

    @PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity handlePost(@RequestBody Product product){
        try {
            product = service.addNewProduct(product);
        } catch (Exception e) {
            CustomResponse cr = new CustomResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cr);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
