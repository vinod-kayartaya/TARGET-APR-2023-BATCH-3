package com.targetindia.dao;

import com.targetindia.model.Customer;
import com.targetindia.utils.DateUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvCustomerDao implements CustomerDao {
    private static final String filename = "customers.csv";

    @Override
    public void addCustomer(Customer c) throws DaoException {
        int id;
        try (
                FileInputStream in = new FileInputStream(filename);
        ) {
            String content = new String(in.readAllBytes());
            String[] lines = content.split("\n");
            String strId = lines[lines.length - 1].split(",")[0];
            id = 1 + Integer.parseInt(strId);
        } catch (Exception e) {
            throw new DaoException(e);
        }

        String line = "%s,%s,%s,%s,%s,%s,%s".formatted(id, c.getFirstname(), c.getLastname(),
                c.getEmail(), c.getPhone(), DateUtil.toString(c.getBirthDate()), c.getCity());

        try (
                FileWriter file = new FileWriter(filename, true);
                PrintWriter out = new PrintWriter(file);
        ) {
            out.println(line);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Customer findById(long id) throws DaoException {
        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            String line = in.readLine(); // skip the header
            while ((line = in.readLine()) != null) {
                String[] fields = line.split(",");
                if (id == Integer.parseInt(fields[0])) {
                    // we found the customer for the given id;
                    // create a Customer object, copy the values from fields to the customer object,
                    // and return the same.
                    Customer c = new Customer();
                    c.setId(id);
                    c.setFirstname(fields[1]);
                    c.setLastname(fields[2]);
                    c.setEmail(fields[3]);
                    c.setPhone(fields[4]);
                    c.setBirthDate(DateUtil.toDate(fields[5]));
                    c.setCity(fields[6]);
                    return c;
                }
            }
            return null; // no customer found for the given id
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


    @Override
    public void updateCustomer(Customer customer) throws DaoException {
        throw new DaoException("method not ready yet!");
    }

    @Override
    public void deleteCustomer(long id) throws DaoException {
        throw new DaoException("method not ready yet!");
    }

    @Override
    public List<Customer> getAllCustomers() throws DaoException {
        List<Customer> customers = new ArrayList<>();
        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            String line = in.readLine(); // skip the header
            while ((line = in.readLine()) != null) {
                String[] fields = line.split(",");
                Customer c = new Customer();
                c.setId(Integer.parseInt(fields[0]));
                c.setFirstname(fields[1]);
                c.setLastname(fields[2]);
                c.setEmail(fields[3]);
                c.setPhone(fields[4]);
                c.setBirthDate(DateUtil.toDate(fields[5]));
                c.setCity(fields[6]);
                customers.add(c);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return customers;
    }

    @Override
    public List<Customer> getCustomersByCity(String city) throws DaoException {
        throw new DaoException("method not ready yet!");
    }

    @Override
    public Customer getCustomerByEmailOrPhone(String emailOrPhone) throws DaoException {
        throw new DaoException("method not ready yet!");
    }

    @Override
    public List<Customer> getCustomersByAge(int minAge, int maxAge) throws DaoException {
        throw new DaoException("method not ready yet!");
    }
}
