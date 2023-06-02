package com.targetindia;

import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    void start(){
        displayBanner();
        int choice;
        while((choice=menu())!=0){
            switch(choice){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    System.out.println("This feature is under development");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you and have a nice day!");
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
        try {
            return KeyboardUtil.getInt("Enter your choice: ");
        } catch (Exception e) {
            log.trace("error while accepting menu choice", e);
            return -1;
        }
    }

    private void displayBanner(){
        try(FileInputStream in = new FileInputStream("banner.txt")){
            System.out.println(new String(in.readAllBytes()));
        }
        catch(Exception e){
            log.warn("Error while accessing banner.txt", e);
            // ignore the error
        }
    }
}
