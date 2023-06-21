package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class GreetingsServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            log.trace("Server listening on port 8888");

            while (true) {
                log.trace("waiting for incoming connection...");
                Socket clientSocket = serverSocket.accept();
                log.trace("Client from {} connected at {}", clientSocket.getInetAddress());

                new Thread(()->{
                    try (
                            OutputStream outputStream = clientSocket.getOutputStream();
                            PrintWriter out = new PrintWriter(outputStream)
                    ) {
                        // a deliberate delay in sending the message
                        Thread.sleep(5000);
                        // write to the client using the output stream/writer
                        out.println("Hello, and welcome to the socket programming");
                        log.trace("closing the client socket...");
                    }// out and outputStream are closed here
                    catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        clientSocket.close();
                        log.trace("client socket closed");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();

            }

        } // serverSocket.close() called here
        catch (Exception e) {
            log.warn("There is an error", e);
        }
    }
}
