package com.targetindia.programs;

import com.targetindia.threads.NumberAdder;
import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadDemo5 {
    @SneakyThrows
    public static void main(String[] args) {

        String outputFilename = "report.txt";
        try (
                PrintWriter out = new PrintWriter(outputFilename)
        ) {
            out.printf("Generated this report on %s%n", new Date().toString());
            String []filenames = {"numbers1.txt", "numbers2.txt", "numbers3.txt", "numbers4.txt"};

            List<Thread> threads = Stream.of(filenames) // stream of String objects
                    .map(filename -> new Thread(new NumberAdder(filename, out)))// stream of Thread objects
                    .peek(Thread::start) // start each thread, call the .start() method
                    .collect(Collectors.toList());

            threads.forEach(ThreadDemo5::join); // for each thread, call the .join() method
            out.println("End of report!");
        } // out.close() called here (only after all threads die/terminated)
    }

    @SneakyThrows
    static void join(Thread t){
        t.join();
    }
}
