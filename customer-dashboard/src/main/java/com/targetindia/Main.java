package com.targetindia;

import com.targetindia.model.Customer;
import com.targetindia.service.CustomerService;
import com.targetindia.service.ServiceException;
import com.targetindia.utils.DateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

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
                case 1:
                    showAllCustomers();
                    break;
                case 2:
                    acceptIdAndDisplayCustomer();
                    break;
                case 3:
                    acceptCityAndShowCustomers();
                    break;
                case 4:
                    acceptEmailOrPhoneAndDisplayCustomer();
                    break;
                case 5:
                    acceptAndSaveCustomerData();
                    break;
                case 7:
                    acceptIdAndDeleteCustomer();
                    break;
                case 8:
                    acceptAgeGroupAndShowCustomers();
                    break;
                case 6:
                    acceptAndModifyCustomerData();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you and have a nice day!");
    }

    private void acceptAndModifyCustomerData() {
        try {
            long id = KeyboardUtil.getLong("Enter customer id to search: ");
            Customer c = service.getCustomer(id);
            if (c == null) {
                System.out.printf("No customer data found for id %d%n", id);
                return;
            }

            String input;
            System.out.println("Enter new value for the fields only if you wish to change: ");
            input = KeyboardUtil.getString("Firstname    : [%s] ".formatted(c.getFirstname()));
            if (!input.isBlank()) {
                c.setFirstname(input);
            }
            input = KeyboardUtil.getString("Lastname      : [%s] ".formatted(c.getLastname()));
            if (!input.isBlank()) {
                c.setLastname(input);
            }
            input = KeyboardUtil.getString("Email         : [%s] ".formatted(c.getEmail()));
            if (!input.isBlank()) {
                c.setEmail(input);
            }
            input = KeyboardUtil.getString("Phone         : [%s] ".formatted(c.getPhone()));
            if (!input.isBlank()) {
                c.setPhone(input);
            }
            input = KeyboardUtil.getString("Date of birth : [%s] ".formatted(DateUtil.toString(c.getBirthDate())));
            if (!input.isBlank()) {
                c.setBirthDate(DateUtil.toDate(input));
            }
            input = KeyboardUtil.getString("City          : [%s] ".formatted(c.getCity()));
            if (!input.isBlank()) {
                c.setCity(input);
            }

            service.updateCustomer(c);
            System.out.println("Customer data updated successfully!");

        } catch (Exception e) {
            log.warn("Error while calling acceptAndModifyCustomerData()", e);
            System.out.println("Whoops! Something went wrong. Check the logs for details.");
        }
    }

    private void acceptIdAndDeleteCustomer() {
        try {
            long id = KeyboardUtil.getLong("Enter customer id to search: ");
            Customer c = service.getCustomer(id);
            if (c == null) {
                System.out.printf("No customer data found for id %d%n", id);
                return;
            }
            displayOneCustomer(c);

            String confirm = KeyboardUtil.getString("This record will be permanently deleted. Type DELETE to confirm: ");
            if (confirm.equals("DELETE")) {
                service.deleteCustomer(id);
                System.out.println("Customer data deleted successfully!");
            } else {
                System.out.println("Delete operation cancelled!");
            }
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    private void acceptAgeGroupAndShowCustomers() {
        try {
            int minAge = KeyboardUtil.getInt("Enter age from: ");
            int maxAge = KeyboardUtil.getInt("Enter age to: ");
            List<Customer> list = service.getCustomersByAge(minAge, maxAge);
            printCustomerList(list);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    private void acceptEmailOrPhoneAndDisplayCustomer() {
        String emailOrPhone = KeyboardUtil.getString("Enter email/phone to search: ");
        Customer c = service.getCustomerByEmailOrPhone(emailOrPhone);
        if (c == null) {
            System.out.printf("No customer data found for email or phone %s%n", emailOrPhone);
            return;
        }
        displayOneCustomer(c);
    }

    private void acceptCityAndShowCustomers() {
        String city = KeyboardUtil.getString("Enter city to search customers from: ");
        List<Customer> customers = service.getCustomersFromCity(city);

        printCustomerList(customers);
    }

    private void printCustomerList(List<Customer> customers) {
        if (customers == null || customers.isEmpty()) {
            System.out.println("No customers to show");
            return;
        }

        line('-', 126);
        System.out.printf("%16s %-25s %-35s %-10s %-25s %-10s%n",
                "ID", "Name", "Email", "Phone", "City", "Birthday");
        line('-', 126);
        for (Customer c : customers) {
            System.out.printf("%16s %-25s %-35s %-10s %-25s %-10s%n",
                    c.getId(),
                    c.getFirstname() + " " + c.getLastname(),
                    c.getEmail(),
                    c.getPhone(),
                    c.getCity(),
                    DateUtil.toString(c.getBirthDate()));
        }
        line('-', 126);
    }

    private void showAllCustomers() {
        List<Customer> customers = service.getAllCustomers();
        printCustomerList(customers);
    }

    private void line(char pattern, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(pattern);
        }
        System.out.println();
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
        } catch (ServiceException e) {
            log.warn("Error while adding a new customer", e);
            System.out.println("Something went wrong. Check the logs for more details.");
            System.out.println(e.getMessage());
        }
    }

    private void acceptIdAndDisplayCustomer() {
        try {
            long id = KeyboardUtil.getLong("Enter customer id to search: ");
            Customer c = service.getCustomer(id);
            if (c == null) {
                System.out.printf("No customer data found for id %d%n", id);
                return;
            }
            displayOneCustomer(c);
        } catch (ServiceException e) {
            log.warn("Error while trying find customer by id", e);
            System.out.println("Something went wrong. Check the logs for more details.");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number and try again");
        }
    }

    private static void displayOneCustomer(Customer c) {
        System.out.printf("Customer data for id %d: %n", c.getId());
        System.out.printf("Name           : %s %s%n", c.getFirstname(), c.getLastname());
        System.out.printf("Email address  : %s%n", c.getEmail());
        System.out.printf("Phone number   : %s%n", c.getPhone());
        System.out.printf("City           : %s%n", c.getCity());
        System.out.printf("Date of birth  : %s%n", DateUtil.toString(c.getBirthDate()));
        System.out.println();
    }

    private int menu() {
        System.out.println("Main menu");
        System.out.println();
        System.out.println("0. Exit");
        System.out.println("1. List all customers");
        System.out.println("2. Search customer by id");
        System.out.println("3. Search customers by city");
        System.out.println("4. Search customer by email/phone");
        System.out.println("5. Add new customer record");
        System.out.println("6. Modify customer data");
        System.out.println("7. Delete customer data");
        System.out.println("8. Search by age group");
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
