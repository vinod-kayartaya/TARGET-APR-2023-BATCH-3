package com.targetindia.dao;

import com.targetindia.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListCustomerDao implements CustomerDao {

    private List<Customer> list = new ArrayList<>();
    private static final String FILE_NAME = "customers.dat";

    public ArrayListCustomerDao() throws DaoException {
        // deserialize the content of customers.dat (if exists) into the list
        File file = new File(FILE_NAME);
        if (file.exists() && file.isFile()) {
            try (
                    FileInputStream f = new FileInputStream(file);
                    ObjectInputStream in = new ObjectInputStream(f);
            ) {
                this.list = (List<Customer>) in.readObject();
            } catch (Exception e) {
                throw new DaoException(e);
            }
        }
    }

    private void persist() throws DaoException {
        try (
                FileOutputStream f = new FileOutputStream(FILE_NAME);
                ObjectOutputStream out = new ObjectOutputStream(f);
        ) {
            out.writeObject(list);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void addCustomer(Customer c) throws DaoException {
        // after adding this customer to the list, call the persist() method
        // TBD: generate a unique id
        // TBD: validation
        // 1. firstname is required
        // 2. email should be unique
        // 3. phone should be unique

        List<String> errors = new ArrayList<>();
        if (c.getFirstname() == null || c.getFirstname().isBlank()) {
            errors.add("First name cannot be null or blank");
        }
        for (Customer c1 : list) {
            if (c1.getEmail().equalsIgnoreCase(c.getEmail())) {
                errors.add("Email is already present in our database");
            }
            if (c1.getPhone().equals(c.getPhone())) {
                errors.add("Phone number is already present in our database");
            }
        }

        if (errors.isEmpty()) {
            // generate id only if there are no errors
            int id = 0;
            for (Customer c2 : list) {
                if (c2.getId() > id) {
                    id = c2.getId();
                }
            }
            c.setId(id + 1);
            list.add(c);
            persist();
        } else {
            throw DaoException.fromList(errors);
        }

    }

    @Override
    public Customer findById(int id) throws DaoException {
        for (Customer c : list) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) throws DaoException {
        // after updating this customer in the list, call the persist() method
        for (int index = 0; index < list.size(); index++) {
            Customer c = list.get(index);
            if (c.getId() == customer.getId()) {
                list.set(index, customer);
                persist();
                return;
            }
        }
        throw new DaoException("Invalid customer id");
    }

    @Override
    public void deleteCustomer(int id) throws DaoException {
        // after deleting this customer from the list, call the persist() method
        for (int index = 0; index < list.size(); index++) {
            Customer c = list.get(index);
            if (c.getId() == id) {
                list.remove(index);
                persist();
                return;
            }
        }
        throw new DaoException("Invalid customer id");
    }

    @Override
    public List<Customer> getAllCustomers() throws DaoException {
        return list;
    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws DaoException {
        List<Customer> customers = new ArrayList<>();
        for (Customer c : list) {
            if (c.getCity().equalsIgnoreCase(city)) {
                customers.add(c);
            }
        }
        return customers;
    }

    @Override
    public Customer getCustomerByEmailOrPhone(String emailOrPhone) throws DaoException {
        for (Customer c : list) {
            if (c.getEmail().equalsIgnoreCase(emailOrPhone) || c.getPhone().equals(emailOrPhone)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Customer> getCustomersByAge(int minAge, int maxAge) throws DaoException {
        throw new DaoException("method not ready yet!");
    }
}
