package com.targetindia.service;

import com.targetindia.dao.CsvCustomerDao;
import com.targetindia.dao.CustomerDao;
import com.targetindia.dao.DaoException;
import com.targetindia.model.Customer;

public class CustomerService {
    private CustomerDao dao = new CsvCustomerDao(); // interface variable; need an object of an implementing class

    public Customer getCustomer(int id) throws ServiceException {
        try {
            return dao.findById(id);
        } catch (NullPointerException | DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void addCustomer(Customer c) throws ServiceException{
        try {
            // do basic validation like:
            // 1. firstname is mandatory
            // 2. email is mandatory
            // 3. phone is mandatory
            // 4. email should not already present in our data store
            // 5. phone should not already present in our data store

            if(c.getFirstname()==null || c.getFirstname().isBlank()){
                throw new ServiceException("Firstname is required, but missing");
            }
            if(c.getEmail()==null || c.getEmail().isBlank()){
                throw new ServiceException("Email address is required, but missing");
            }
            if(c.getPhone()==null || c.getPhone().isBlank()){
                throw new ServiceException("Phone number is required, but missing");
            }

            dao.addCustomer(c);

        } catch (NullPointerException | DaoException e) {
            throw new ServiceException(e);
        }
    }
}
