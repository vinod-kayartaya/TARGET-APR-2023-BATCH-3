package com.targetindia.dao;

import com.targetindia.model.Customer;

import java.util.List;

public interface CustomerDao {
    // CRUD operations related to Customer
    public void addCustomer(Customer customer) throws DaoException;

    public Customer findById(long id) throws DaoException;

    public void updateCustomer(Customer customer) throws DaoException;

    public void deleteCustomer(long id) throws DaoException;

    // Query operations related to Customer

    public List<Customer> getAllCustomers() throws DaoException;

    public List<Customer> getCustomersByCity(String city) throws DaoException;

    public Customer getCustomerByEmailOrPhone(String emailOrPhone) throws DaoException;

    public List<Customer> getCustomersByAge(int minAge, int maxAge) throws DaoException;
}
