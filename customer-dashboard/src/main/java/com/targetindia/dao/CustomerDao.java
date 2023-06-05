package com.targetindia.dao;

import com.targetindia.model.Customer;

public interface CustomerDao {
    // CRUD operations related to Customer
    public void addCustomer(Customer customer) throws DaoException;
    public Customer findById(int id) throws DaoException;
    public void updateCustomer(Customer customer) throws DaoException;
    public void deleteCustomer(int id) throws DaoException;

    // Query operations related to Customer
}
