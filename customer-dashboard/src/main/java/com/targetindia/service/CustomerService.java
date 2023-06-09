package com.targetindia.service;

import com.targetindia.dao.CustomerDao;
import com.targetindia.dao.DaoException;
import com.targetindia.dao.DaoFactory;
import com.targetindia.dao.HashMapCustomerDao;
import com.targetindia.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    // following is an illustration of TIGHT-COUPLING, which is not a good practice
    // Need to change the same to LOOSE-COUPLING, using factory-method design pattern
    // private CustomerDao dao = new HashMapCustomerDao(); // interface variable; need an object of an implementing class

    // loose coupling
    private CustomerDao dao = DaoFactory.getCustomerDao();

    public Customer getCustomer(long id) throws ServiceException {
        try {
            return dao.findById(id);
        } catch (NullPointerException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void addCustomer(Customer c) throws ServiceException {
        try {
            // do basic validation like:
            // 1. firstname is mandatory
            // 2. email is mandatory
            // 3. phone is mandatory
            // 4. email should not already present in our data store
            // 5. phone should not already present in our data store

            List<String> errors = new ArrayList<>();
            if (c.getFirstname() == null || c.getFirstname().isBlank()) {
                errors.add("Firstname is required, but missing");
            }
            if (c.getEmail() == null || c.getEmail().isBlank()) {
                errors.add("Email address is required, but missing");
            }
            if (c.getPhone() == null || c.getPhone().isBlank()) {
                errors.add("Phone number is required, but missing");
            }
            if (dao.getCustomerByEmailOrPhone(c.getEmail()) != null) {
                errors.add("Email is already present in our database");
            }
            if (dao.getCustomerByEmailOrPhone(c.getPhone()) != null) {
                errors.add("Phone number is already present in our database");
            }
            if (errors.isEmpty()) {
                dao.addCustomer(c);
            } else {
                throw ServiceException.fromList(errors);
            }
        } catch (NullPointerException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    public List<Customer> getCustomersFromCity(String city) {
        return dao.getCustomersByCity(city);
    }

    public Customer getCustomerByEmailOrPhone(String emailOrPhone) {
        return dao.getCustomerByEmailOrPhone(emailOrPhone);
    }

    public List<Customer> getCustomersByAge(int minAge, int maxAge) throws DaoException {
        return dao.getCustomersByAge(minAge, maxAge);
    }
}
