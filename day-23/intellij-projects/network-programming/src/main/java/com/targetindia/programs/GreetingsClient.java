package com.targetindia.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.Socket;

@Slf4j
public class GreetingsClient {

    @SneakyThrows
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 8888);
        ) {
            log.trace("Connected to the server: " + socket.getInetAddress());
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = inputStream.readAllBytes();
            String response = new String(bytes);
            log.trace("Server response is - {}", response);
        } // socket.close() called
    }
}
