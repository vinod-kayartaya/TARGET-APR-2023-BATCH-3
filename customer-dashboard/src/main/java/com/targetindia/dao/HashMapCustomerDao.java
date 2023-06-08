package com.targetindia.dao;

import com.targetindia.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCustomerDao implements CustomerDao {

    private Map<Long, Customer> customerMap = new HashMap<>();
    private static final String FILE_NAME = "customers.map";

    public HashMapCustomerDao() {
        File file = new File(FILE_NAME);
        if (file.exists() && file.isFile()) {
            try (
                    FileInputStream f = new FileInputStream(file);
                    ObjectInputStream in = new ObjectInputStream(f)
            ) {
                this.customerMap = (Map<Long, Customer>) in.readObject();
            } catch (Exception e) {
                throw new DaoException(e);
            }
        }
    }

    private void persist() throws DaoException {
        try (
                FileOutputStream f = new FileOutputStream(FILE_NAME);
                ObjectOutputStream out = new ObjectOutputStream(f)
        ) {
            out.writeObject(customerMap);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void addCustomer(Customer c) throws DaoException {
        // need to generate the id
        c.setId(System.currentTimeMillis());
        customerMap.put(c.getId(), c);
        persist();
    }

    @Override
    public Customer findById(long id) throws DaoException {
        return customerMap.get(id);
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {
        if (customerMap.containsKey(customer.getId())) {
            customerMap.put(customer.getId(), customer);
            persist();
        } else {
            throw new DaoException("Customer id not found to update");
        }
    }

    @Override
    public void deleteCustomer(long id) throws DaoException {
        if (customerMap.containsKey(id)) {
            customerMap.remove(id);
            persist();
        } else {
            throw new DaoException("Customer id not found to delete");
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws DaoException {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws DaoException {
        List<Customer> customers = new ArrayList<>();
        for (Customer c : customerMap.values()) {
            if (c.getCity().equalsIgnoreCase(city)) {
                customers.add(c);
            }
        }
        return customers;
    }

    @Override
    public Customer getCustomerByEmailOrPhone(String emailOrPhone) throws DaoException {
        for (Customer c : customerMap.values()) {
            if (c.getEmail().equalsIgnoreCase(emailOrPhone) || c.getPhone().equals(emailOrPhone)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Customer> getCustomersByAge(int minAge, int maxAge) throws DaoException {
        throw new DaoException("Method not ready yet!");
    }
}
