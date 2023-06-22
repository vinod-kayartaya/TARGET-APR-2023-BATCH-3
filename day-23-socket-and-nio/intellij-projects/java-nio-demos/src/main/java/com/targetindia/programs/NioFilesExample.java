package com.targetindia.programs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioFilesExample {
    public static void main(String[] args) {
        demo8();
    }

     static void demo8() {
         Path path2 = Path.of( "/Users/vinod", "Documents", "_temp", "test.txt");

         System.out.printf("Permissions on the file %s: %n", path2.getFileName());
         System.out.printf("is readable? : %s%n", Files.isReadable(path2));
         System.out.printf("is writable? : %s%n", Files.isWritable(path2));
         System.out.printf("is executable? : %s%n", Files.isExecutable(path2));
     }

    static void demo7() {
        Path path1 = Path.of( "/Users/vinod", "Desktop", "test.txt");
        Path path2 = Path.of( "/Users/vinod", "Documents", "_temp", "test.txt");

        try {
            Files.move(path1, path2);
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void demo6() {
        Path path = Path.of( "/Users/vinod", "Desktop", "test.txt");
        try {
            // Files.createFile(path);
            Files.writeString(path, "My name is vinod\nI live in Bangalore.\n");
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void demo5() {
        Path path = Path.of( "/Users/vinod", "Desktop",
                "react-projects", "react-basics", "src", "components", "App.js");
        try {
            Files.readAllLines(path).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void demo4() {
        Path path = Path.of( "/Users/vinod", "Desktop",
                "react-projects", "react-basics", "src", "components", "App.js");
        try {
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void demo3() {
        // copy one file to another
        Path srcPath = Path.of("src", "main", "java", "com", "targetindia", "programs", "NioFilesExample.java");
        Path destPath = Path.of("/", "Users", "vinod", "Desktop", String.valueOf(srcPath.getFileName()));

        try {
            Files.deleteIfExists(destPath);
            Files.copy(srcPath, destPath);
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void demo2() {
        // create a new directory + subdirectory in the given path
        Path path = Paths.get("/Users/vinod/Desktop/vinod/kumar/bangalore");
        try {
            Files.createDirectories(path);
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void demo1() {
        // check if the file exists or not
        // Path path = Path.of( "/Users/vinod", "Desktop", "react-projects", "react-basics", "package.json");
        // Path path = Paths.get("/Users/vinod/Desktop/react-projects/react-basics/package.json");
        // Path path = Paths.get("pom.xml");
        Path path = Path.of("src", "main", "java", "com", "targetindia", "programs", "NioFilesExample.java");
        if(Files.exists(path)){
            System.out.printf("%s is a valid path%n", path.getFileName());
        }
        else{
            System.out.printf("%s is an invalid path%n", path.getFileName());
        }
    }
}
