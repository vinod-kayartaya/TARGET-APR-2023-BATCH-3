package com.targetindia.programs;

import com.targetindia.model.Employee;
import com.targetindia.utils.KeyboardUtil;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class AcceptAndWriteEmployeeDetailsToFile {

    public static void main(String[] args) {
        String filename = "employees.dat";

        try (
                FileOutputStream file = new FileOutputStream(filename);
                // cannot use the append option with a file used by ObjectOutputStream
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            while (true) {
                Employee emp = acceptEmployeeDetails();
                out.writeObject(emp);

                String ans = KeyboardUtil.getString("Do you want to add another (yes/no): [yes] ");
                if(ans.equalsIgnoreCase("no")){
                    break;
                }
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static Employee acceptEmployeeDetails() {
        System.out.println("Enter employee details");
        int id = KeyboardUtil.getInt("ID       : ");
        String name = KeyboardUtil.getString("Name     : ");
        double salary = KeyboardUtil.getDouble("Salary   : ");
        return new Employee(id, name, salary);
    }
}
