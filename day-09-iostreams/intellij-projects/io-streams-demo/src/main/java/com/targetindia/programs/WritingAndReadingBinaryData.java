package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.*;

public class WritingAndReadingBinaryData {

    static String filename = "numbers.dat";

    static void demo1() throws FileNotFoundException {
        double d = 1.9;
        System.out.println(d);

        PrintWriter writer = new PrintWriter(filename);
        // always writes anything as a string
        writer.print(d);
        writer.close();

        System.out.println("number written to the file.");
    }

    static void demo2() throws Exception {
        double d = 1.9; // d contains 8 bytes
        FileOutputStream file = new FileOutputStream(filename);
        long num = Double.doubleToLongBits(d);
        byte[] writeBuffer = new byte[8];
        writeBuffer[0] = (byte) (num >>> 56);
        writeBuffer[1] = (byte) (num >>> 48);
        writeBuffer[2] = (byte) (num >>> 40);
        writeBuffer[3] = (byte) (num >>> 32);
        writeBuffer[4] = (byte) (num >>> 24);
        writeBuffer[5] = (byte) (num >>> 16);
        writeBuffer[6] = (byte) (num >>> 8);
        writeBuffer[7] = (byte) (num >>> 0);
        file.write(writeBuffer);
        file.close();
    }

    static void demo3() throws Exception {
        try (
                FileOutputStream file = new FileOutputStream(filename, true);
                DataOutputStream out = new DataOutputStream(file);
        ) {
            while (true) {
                double d = KeyboardUtil.getDouble("Enter a number (0 to stop): ");
                if (d == 0) {
                    break;
                }
                out.writeDouble(d);
            }

            System.out.println("Data stored in 'numbers.dat' file");

        } // out.close(), file.close() here
    }

    static void demo4() throws Exception {
        try (
                FileInputStream file = new FileInputStream(filename);
                DataInputStream in = new DataInputStream(file);
        ) {
            while (true) {
                try {
                    double d = in.readDouble();
                    System.out.println(d);
                } catch (EOFException e) {
                    break;
                }
            }
        } // in.close(), file.close() called here
    }

    public static void main(String[] args) throws Exception {
        demo4();
    }
}
