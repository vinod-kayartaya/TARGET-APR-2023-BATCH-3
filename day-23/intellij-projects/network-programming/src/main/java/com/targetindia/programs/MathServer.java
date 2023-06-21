package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MathServer {
    static long factorial(int num) {
        long f = 1;
        for (int i = 2; i <= num; i++) {
            f *= i;
        }
        return f;
    }

    static double power(int a, int b) {
        return Math.pow(a, b);
    }

    static double sqrt(int n) {
        return Math.sqrt(n);
    }


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            log.trace("Server listening on port 8080...");

            while (true) {
                // accept client connections endlessly
                log.trace("Waiting for new client connection...");
                Socket clientSocket = serverSocket.accept();
                log.trace("Accepted connection from the client at {}", clientSocket.getInetAddress());
                log.trace("Handling the client request using a new thread...");
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            log.trace("ClientHandler constructor received a socket from {}", clientSocket.getInetAddress());
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            log.trace("thread is in the running state now...");

            try {
                log.trace("inside the try block");
                InputStream inputStream = clientSocket.getInputStream();
                log.trace("got an object for input stream");
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                log.trace("reading the method invocation request information from the client...");
                ObjectInputStream in = new ObjectInputStream(inputStream);
                log.trace("got an object of object input stream ");
                // read the information sent by the client (a Map object with 'methodName' and 'args' keys)
                Map<String, Object> request = (Map<String, Object>) in.readObject();
                String methodName = (String) request.get("methodName");
                Object[] args = (Object[]) request.get("args");

                Map<String, Object> response = new HashMap<>();
                switch (methodName) {
                    case "factorial":
                        int num = (int) args[0];
                        response.put("result", factorial(num));
                        break;
                    case "power":
                        int a = (int) args[0];
                        int b = (int) args[1];
                        response.put("result", power(a, b));
                        break;
                    case "sqrt":
                        response.put("result", sqrt((int) args[0]));
                        break;
                    default:
                        response.put("error", "Invalid method name");
                }
                out.writeObject(response);
                out.close();
                in.close();
                clientSocket.close();
            }
            catch (Exception e) {
                log.warn("There was an error", e);
                throw new RuntimeException(e);
            }
        }


    }
}
