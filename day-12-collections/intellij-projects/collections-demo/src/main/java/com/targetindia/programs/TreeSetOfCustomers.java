package com.targetindia.programs;

import com.targetindia.entity.Customer;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetOfCustomers {
    public static void main(String[] args) {
        Set<Customer> customers = new TreeSet<>();
        customers.add(new Customer(4, "Debee Hourican", 5.7));
        customers.add(new Customer(4, "Sandra Dee", 5.7));
        customers.add(new Customer(4, "Sandra Dee", 5.7));
        customers.add(new Customer(4, "Sandra Dee", 5.8));
        customers.add(new Customer(5, "Keefe Keene", 5.7));
        customers.add(new Customer(6, "Hertha Dunlop", 7.2));
        customers.add(new Customer(9, "Issiah Dyble", 5.3));
        customers.add(new Customer(10, "Helli Baxendale", 4.7));
        customers.add(new Customer(3, "Claudell Atterbury", 6.9));
        customers.add(new Customer(3, "Claudell Atterbury", 6.9));
        customers.add(new Customer(7, "Mac Puffett", 5.5));
        customers.add(new Customer(7, "Mac Puffett", 5.5));
        customers.add(new Customer(7, "Mac Puffett", 5.5));
        customers.add(new Customer(7, "Mac Puffett", 5.5));
        customers.add(new Customer(8, "Jamie Balaam", 7.0));
        customers.add(new Customer(1, "Elmira Silverston", 5.7));
        customers.add(new Customer(2, "Vinnie Daoust", 4.9));
        customers.add(new Customer(3, "Claudell Atterbury", 6.9));
        customers.add(new Customer(3, "Claudell Atterbury", 6.9));

        for(Customer c: customers){
            System.out.println(c);
        }
    }
}
