package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;
import lombok.SneakyThrows;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MathClient {
    static int menu() {
        System.out.println("Your available options are: ");
        System.out.println("----------------------------");
        System.out.println("0. Exit");
        System.out.println("1. Factorial");
        System.out.println("2. Power");
        System.out.println("3. Square root");
        try {
            int choice = KeyboardUtil.getInt("Enter your choice: ");
            return choice;
        } catch (Exception e) {
            return -1;
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        theLoop:
        while (true) {
            int choice = menu();
            try (
                    Socket socket = new Socket("localhost", 8080);
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())
            ) {
                String methodName = null;
                Object[] methodArgs = null;
                switch (choice) {
                    case 0:
                        break theLoop;
                    case 1:
                        methodName = "factorial";
                        int num = KeyboardUtil.getInt("Enter the input for factorial: ");
                        methodArgs = new Object[]{num};
                        break;
                    case 2:
                        methodName = "power";
                        int base = KeyboardUtil.getInt("Enter the base: ");
                        int exponent = KeyboardUtil.getInt("Enter the exponent: ");
                        methodArgs = new Object[]{base, exponent};
                        break;
                    case 3:
                        methodName = "sqrt";
                        int n = KeyboardUtil.getInt("Enter the input for square root: ");
                        methodArgs = new Object[]{n};
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again!");
                        continue theLoop;
                }

                Map<String, Object> request = new HashMap<>();
                request.put("methodName", methodName);
                request.put("args", methodArgs);

                out.writeObject(request);
                Map<String, Object> response = (Map<String, Object>) in.readObject();
                if(response.containsKey("result")){
                    System.out.printf("The result = %s%n", response.get("result"));
                }
                else if(response.containsKey("error")){
                    System.out.printf("There wan error: " + response.get("error"));
                }

            } // out, in and socket will be closed here
        } // end of the while loop
    }
}
