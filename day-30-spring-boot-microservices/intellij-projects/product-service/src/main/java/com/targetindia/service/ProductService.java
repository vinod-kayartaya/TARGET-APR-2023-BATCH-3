package com.targetindia.service;

import com.targetindia.entity.Product;
import com.targetindia.model.CategoryDTO;
import com.targetindia.model.ProductDTO;
import com.targetindia.model.ProductList;
import com.targetindia.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    // dependencies
    @Autowired
    private ProductRepository repo;

    @Value("${service.url.category}")
    private String categoryServiceUrl;
    @Value("${service.url.supplier}")
    private String supplierServiceUrl;



    public ProductList getAllProducts(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Product> page = repo.findAll(pageable);
        return new ProductList(page.toList());
    }

    public ProductDTO getOneProduct(Integer productId) {
        Optional<Product> result = repo.findById(productId);
        if(result.isEmpty()){
            return null;
        }

        Product p1 = result.get();
        ProductDTO p2 = new ProductDTO();

        // copy the values from p1 to p2
        p2.setProductId(p1.getProductId());
        p2.setProductName(p1.getProductName());
        p2.setQuantityPerUnit(p1.getQuantityPerUnit());
        p2.setUnitPrice(p1.getUnitPrice());
        p2.setUnitsInStock(p1.getUnitsInStock());
        p2.setUnitsOnOrder(p1.getUnitsOnOrder());
        p2.setReorderLevel(p1.getReorderLevel());
        p1.setDiscontinued(p1.getDiscontinued());

        try {
            // visit the category-service and get the response in CategoryDTO format
            RestTemplate template = new RestTemplate();
            CategoryDTO c1 = template.getForObject(
                    categoryServiceUrl + p1.getCategoryId(), CategoryDTO.class);
            p2.setCategory(c1);
        }
        catch(Exception e){
            log.warn("error", e);
        }


        return p2;
    }

    public ProductList getProductsByField(String fieldName, String value) {
        List<Product> products = null;

        switch (fieldName) {
            case "productName":
                products = repo.findByProductName(value);
                break;
            case "categoryId":
                products = repo.findAllByCategoryId(Integer.valueOf(value));
                break;
            case "supplierId":
                products = repo.findAllBySupplierId(Integer.valueOf(value));
                break;
            case "discontinued":
                products = repo.findAllByDiscontinued(Integer.valueOf(value));
                break;
            case "unitsInStock":
                products = repo.findAllByUnitsInStock(Integer.valueOf(value));
        }
        if (products == null) {
            return null;
        }
        return new ProductList(products);
    }

    public ProductList getProductsByPriceRange(Double min, Double max) {
        List<Product> list = repo.findAllByUnitPriceBetween(min, max);
        return new ProductList(list);
    }

    public Product addNewProduct(Product product) {
        // remove the id from the entity, so that it will be auto generated!
        product.setProductId(null);
        return repo.save(product); // if id is missing or not in DB, will execute SQL INSERT, otherwise SQL UPDATE
    }
}
