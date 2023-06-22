package com.targetindia.threads;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class NumberAdder implements Runnable {

    private String filename;
    private PrintWriter out;

    public NumberAdder(String filename, PrintWriter out) {
        this.filename = filename;
        this.out = out;
    }

    @SneakyThrows
    @Override
    public void run() {
        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            String line;
            double sum = 0;
            int count = 0;
            while ((line = in.readLine()) != null) {
                sum += Double.parseDouble(line);
                count++;
            }
            out.printf("filename=%s, count = %d, sum = %.2f%n", filename, count, sum);
        } // in.close(), reader.close() happen here
    }
}
