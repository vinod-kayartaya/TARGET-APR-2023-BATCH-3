package com.targetindia;

import com.targetindia.model.Customer;
import com.targetindia.service.CustomerService;
import com.targetindia.service.ServiceException;
import com.targetindia.utils.DateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.security.Key;
import java.util.Date;
import java.util.InputMismatchException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    private CustomerService service = new CustomerService();

    void start() {
        displayBanner();
        int choice;
        while ((choice = menu()) != 0) {
            switch (choice) {
                case 2:
                    acceptIdAndDisplayCustomer();
                    break;
                case 5:
                    acceptAndSaveCustomerData();
                    break;
                case 1:
                case 3:
                case 4:
                case 6:
                case 7:
                    System.out.println("This feature is under development");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you and have a nice day!");
    }

    private void acceptAndSaveCustomerData() {
        try {
            System.out.println("Enter new customer details: ");
            String firstname = KeyboardUtil.getString("Firstname         : ");
            String lastname = KeyboardUtil.getString("Lastname          : ");
            String email = KeyboardUtil.getString("Email address     : ");
            String phone = KeyboardUtil.getString("Phone number      : ");
            Date birthDate = KeyboardUtil.getDate("Date of birth     : ");
            String city = KeyboardUtil.getString("City              : ");

            Customer c = new Customer();
            c.setFirstname(firstname);
            c.setLastname(lastname);
            c.setEmail(email);
            c.setPhone(phone);
            c.setBirthDate(birthDate);
            c.setCity(city);

            service.addCustomer(c);
            System.out.println("New customer data saved");
        }catch (ServiceException e){
            log.warn("Error while adding a new customer", e);
            System.out.println("Something went wrong. Check the logs for more details.");
            System.out.println(e.getMessage());
        }
    }

    private void acceptIdAndDisplayCustomer() {
        try {
            int id = KeyboardUtil.getInt("Enter customer id to search: ");
            Customer c = service.getCustomer(id);
            if (c == null) {
                System.out.printf("No customer data found for id %d%n", id);
                return;
            }

            System.out.printf("Customer data for id %d: %n", id);
            System.out.printf("Name           : %s %s%n", c.getFirstname(), c.getLastname());
            System.out.printf("Email address  : %s%n", c.getEmail());
            System.out.printf("Phone number   : %s%n", c.getPhone());
            System.out.printf("City           : %s%n", c.getCity());
            System.out.printf("Date of birth  : %s%n", DateUtil.toString(c.getBirthDate()));
            System.out.println();
        } catch (ServiceException e) {
            log.warn("Error while trying find customer by id", e);
            System.out.println("Something went wrong. Check the logs for more details.");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number and try again");
        }
    }

    private int menu() {
        System.out.println("Main menu");
        System.out.println();
        System.out.println("0. Exit");
        System.out.println("1. List all customers.csv");
        System.out.println("2. Search customer by id");
        System.out.println("3. Search customers.csv by city");
        System.out.println("4. Search customer by email/phone");
        System.out.println("5. Add new customer record");
        System.out.println("6. Modify customer data");
        System.out.println("7. Delete customer data");
        try {
            return KeyboardUtil.getInt("Enter your choice: ");
        } catch (Exception e) {
            log.trace("error while accepting menu choice", e);
            return -1;
        }
    }

    private void displayBanner() {
        try (FileInputStream in = new FileInputStream("banner.txt")) {
            System.out.println(new String(in.readAllBytes()));
        } catch (Exception e) {
            log.warn("Error while accessing banner.txt", e);
            // ignore the error
        }
    }
}
