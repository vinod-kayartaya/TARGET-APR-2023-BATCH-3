package com.targetindia.programs;

import com.targetindia.threads.GreetingThread;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo1 {

    @SneakyThrows
    public static void main(String[] args) {
        GreetingThread gt = new GreetingThread();

        log.trace("Start of main()");
        gt.start();
        for (int i = 0; i < 15; i++) {
            log.trace("value of i in main() is {}", i);
            Thread.sleep(100);
        }

        log.trace("End of main()");
    }
}
