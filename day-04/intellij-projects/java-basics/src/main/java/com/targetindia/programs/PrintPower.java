package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintPower {
    static Logger log = LoggerFactory.getLogger(PrintPower.class);

    public static void main(String[] args) {
        // logger object has different methods to log the outputs
        // trace(), debug(), info(), warn() and error()
        // a log message can be associated with a log LEVEL
        // the different log levels are: ALL, TRACE, DEBUG, INFO, WARN, ERROR
        // We can control what levels of logs to be recorded.
        // If you specify a level, then all the higher levelled logs also will be recorded
        // For example, if the log level is set to INFO, then
        // the log.info(), log.warn() and log.error() outputs will be recorded and,
        // the log.trace(), log.debug() will be ignored

        // printLogs();
        int a = KeyboardUtil.getInt("Enter a number: ");
        int b = KeyboardUtil.getInt("Enter another number: ");
        log.trace("user input for a is {}", a);
        log.trace("user input for b is {}", b);

        long pow = 1;
        for(int i=0; i<b; i++){
            pow *= a;
        }
        log.info("{} raised to the power of {} is {}", a, b, pow);
    }

    private static void printLogs() {
        log.trace("this is a trace message");
        log.debug("this is a debug message");
        log.info("this is an info message");
        log.warn("this is a warn message");
        log.error("this is an error message");
    }
}
