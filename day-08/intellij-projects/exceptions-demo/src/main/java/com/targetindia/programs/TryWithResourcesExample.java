package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;

@Slf4j
public class TryWithResourcesExample {
    public static void main(String[] args) {
        String filename = "./pom.xmll";

        try (
                // declare and initialize only AutoCloseable types
                MyOwnCloseableClass mocc = new MyOwnCloseableClass();
                FileReader reader = new FileReader(filename);
        ) {
            log.trace("first line inside the try block");
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            log.trace("last line inside the try block");
        } // reader.close() and mocc.close() are called here automatically
        catch (Exception e) {
            log.warn("Error while reading file", e);
        }
        finally {
            log.trace("from inside of finally block!");
        }
    }
}
