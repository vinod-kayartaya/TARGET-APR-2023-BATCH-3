package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteToTextFile {

    static void demo1() {
        String filename = "data.csv";

        File f = new File(filename);
        boolean firstTime = !f.exists();

        try (
                FileWriter file = new FileWriter(f, true);
                PrintWriter out = new PrintWriter(file);
        ) {
            if (firstTime) {
                out.println("name,email,city");
            }

            while (true) {
                String name = KeyboardUtil.getString("Enter name: ");
                String email = KeyboardUtil.getString("Enter email: ");
                String city = KeyboardUtil.getString("Enter city: ");
                out.printf("%s,%s,%s%n", name, email, city);

                String ans = KeyboardUtil.getString("Do you want to add another (yes/no): [yes]");
                if (ans.equalsIgnoreCase("no")) {
                    break;
                }
            }
            System.out.println("Data stored in data1.csv file");
        }// out.close() and file.close() called here
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        demo1();
    }
}
