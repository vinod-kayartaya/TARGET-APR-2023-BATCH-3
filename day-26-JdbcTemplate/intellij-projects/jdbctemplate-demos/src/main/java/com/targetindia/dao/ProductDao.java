package com.targetindia.dao;

import com.targetindia.model.Product;

import java.util.List;

public interface ProductDao {
    public void add(Product product) throws DaoException;
    public Product findById(Integer productId) throws DaoException;
    public void update(Product product) throws DaoException;
    public void delete(Integer productId) throws DaoException;

    public long count() throws DaoException;
    public List<Product> findAll() throws DaoException;
    public List<Product> findAllByCategoryId(Integer categoryId) throws DaoException;
    public List<Product> findAllBySupplierId(Integer supplierId) throws DaoException;
    public List<Product> findAllDiscontinuedProducts() throws DaoException;
    public List<Product> findAllOutOfStockProducts() throws DaoException;
    public List<Product> findAllByPriceRange(double min, double max) throws DaoException;
}
