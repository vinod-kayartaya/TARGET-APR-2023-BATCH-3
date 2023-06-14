package com.targetindia.programs;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ThreadDemo4 {
    @SneakyThrows
    static void convertToWords(List<String> words, String sentence) {
        for (String word : sentence.split("\s")) {
            words.add(word);
            Thread.sleep(1); // the current thread will goto the BLOCKED/WAITING STATE
            // and then it will goto the RUNNABLE state, waits for its turn to become RUNNING thread
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        List<String> words = new Vector<>();
        String s1 = "my name is vinod and i live in bangalore. bangalore is a nice city.";
        String s2 = "java is a very powerful and popular programming language";
        String s3 = "the quick and brown fox jumps over lazy dog";

        Thread t1 = new Thread(() -> convertToWords(words, s1));
        Thread t2 = new Thread(() -> convertToWords(words, s2));
        Thread t3 = new Thread(() -> convertToWords(words, s3));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        // we need to wait until all the tasks are finished by the above threads
        System.out.println(words);
        System.out.printf("word count = %d%n", words.size());
    }
}
