package com.targetindia.programs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFromTextFile {
    static String filename = "/Users/vinod/Desktop/react-projects/react-basics/package.json";

    static void demo1() {
        try (
                FileInputStream file = new FileInputStream(filename);
        ) {
            int ch;
            while ((ch = file.read()) != -1) {
                System.out.print((char) ch);
            }
        } // file.close() called here automatically
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void demo2() {
        try (
                FileInputStream file = new FileInputStream(filename)
        ) {
            byte[] bytes = new byte[1024];
            int loopCount = 0;
            while (file.read(bytes) != -1) {
                System.out.print(new String(bytes).trim());
                bytes = new byte[1024];
                loopCount++;
            }
            System.out.println("\n\nTotal number of loops iterated = " + loopCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void demo3() {
        try (
                FileInputStream file = new FileInputStream(filename);
                InputStreamReader isr = new InputStreamReader(file);
                BufferedReader in = new BufferedReader(isr);
        ) {
            String line;
            int loopCount = 0;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                loopCount++;
            }
            System.out.printf("Loop count = %d%n", loopCount);
        } // file.close(), isr.close(), in.close() called here
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void demo4() {
        try (
                FileInputStream file = new FileInputStream(filename);
                Scanner sc = new Scanner(file);
        ) {
            int loopCount = 0;
            while (true) {
                try {
                    String line = sc.nextLine();
                    System.out.println(line);
                    loopCount++;
                } catch (NoSuchElementException e) {
                    break;
                }
            }
            System.out.printf("Loop count = %d%n", loopCount);
        } // file.close() and sc.close()
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void demo5() {
        try (
                FileInputStream file = new FileInputStream(filename)
        ) {
            byte[] bytes = file.readAllBytes();
            System.out.printf("size of the file is %d bytes%n", bytes.length);
            String content = new String(bytes);
            System.out.println(content);
        }// file.close()
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void demo6() {
        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            String line;
            int loopCount = 0;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                loopCount++;
            }
            System.out.printf("Loop count = %d%n", loopCount);
        } // reader.close() called here
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        demo6();
    }
}
