package com.targetindia.programs;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadDemo6 {

//    @SneakyThrows
//    static void convertToWords(List<String> words, String sentence) {
//        String[] strWords = sentence.split("\s");
//
//        // any thread that depends on "words", which is a shared resource, will have to wait
//        // if a thread is not using "words" for its operations, then that thread may continue to execute
//        synchronized(words) {
//            for (String word : strWords) {
//                System.out.printf("adding '%s' to the list..%n", word);
//                words.add(word);
//                Thread.sleep(1); // the current thread will goto the BLOCKED/WAITING STATE
//                // and then it will goto the RUNNABLE state, waits for its turn to become RUNNING thread
//            }
//        }
//    }

    @SneakyThrows
    static synchronized void convertToWords(List<String> words, String sentence) {
        String[] strWords = sentence.split("\s");

        for (String word : strWords) {
            System.out.printf("adding '%s' to the list..%n", word);
            words.add(word);
            Thread.sleep(1); // the current thread will goto the BLOCKED/WAITING STATE
            // and then it will goto the RUNNABLE state, waits for its turn to become RUNNING thread
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        // thread safety demo
        List<String> words = new Vector<>();
        String s1 = "my name is vinod and i live in bangalore. bangalore is a nice city.";
        String s2 = "java is a very powerful and popular programming language";
        String s3 = "the quick and brown fox jumps over lazy dog";

        // these threads share a  common resource "words" for mutation
        List<Thread> threads = Stream.of(s1, s2, s3)
                .map(sentence -> new Thread(() -> convertToWords(words, sentence)))
                .peek(Thread::start) // .peek(thread->thread.start())
                .collect(Collectors.toList());

        // the following thread has nothing to do with the shared resource "words"
        new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                System.out.printf("value of i is %d%n", i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        threads.forEach(ThreadDemo5::join);

        System.out.println(words);
    }

}
