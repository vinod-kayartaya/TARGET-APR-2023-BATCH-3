package com.targetindia.dao;

import com.targetindia.model.Customer;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayListCustomerDao implements CustomerDao {

    private List<Customer> list = new ArrayList<>();
    private static final String FILE_NAME = "customers.dat";

    public ArrayListCustomerDao() throws DaoException {
        // deserialize the content of customers.dat (if exists) into the list
        File file = new File(FILE_NAME);
        if (file.exists() && file.isFile()) {
            try (
                    FileInputStream f = new FileInputStream(file);
                    ObjectInputStream in = new ObjectInputStream(f)
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
                ObjectOutputStream out = new ObjectOutputStream(f)
        ) {
            out.writeObject(list);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void addCustomer(Customer c) throws DaoException {
        // after adding this customer to the list, call the persist() method
        // generate id only if there are no errors
        Random r = new Random(1000);
        c.setId(System.currentTimeMillis() + r.nextInt());
        list.add(c);
        persist();
    }

    @Override
    public Customer findById(long id) throws DaoException {
//        for (Customer c : list) {
//            if (c.getId() == id) {
//                return c;
//            }
//        }
//        return null;
        Optional<Customer> data = list.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        return data.isPresent() ? data.get() : null;
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
    public void deleteCustomer(long id) throws DaoException {
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
        return list.stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws DaoException {
//        List<Customer> customers = new ArrayList<>();
//        for (Customer c : list) {
//            if (c.getCity().equalsIgnoreCase(city)) {
//                customers.add(c);
//            }
//        }
//        return customers;
        return list.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerByEmailOrPhone(String emailOrPhone) throws DaoException {
//        for (Customer c : list) {
//            if (c.getEmail().equalsIgnoreCase(emailOrPhone) || c.getPhone().equals(emailOrPhone)) {
//                return c;
//            }
//        }
//        return null;

        Optional<Customer> data = list.stream()
                .filter(c -> c.getPhone().equalsIgnoreCase(emailOrPhone) ||
                        c.getEmail().equalsIgnoreCase(emailOrPhone))
                .findFirst();

        return data.isEmpty() ? null : data.get();
    }

    @Override
    public List<Customer> getCustomersByAge(int minAge, int maxAge) throws DaoException {
        return list.stream()
                .filter(c -> c.getBirthDate() != null)
                .filter(c -> age(c.getBirthDate()) >= minAge && age(c.getBirthDate()) <= maxAge)
                .collect(Collectors.toList());
    }

    private static int age(Date dob) {
        return new Date(System.currentTimeMillis() - dob.getTime()).getYear() - 70; // 70-->1970
    }
}
