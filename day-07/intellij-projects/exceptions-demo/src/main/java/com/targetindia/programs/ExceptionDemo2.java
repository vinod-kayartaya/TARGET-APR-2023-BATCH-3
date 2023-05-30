package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ExceptionDemo2 {
    public static void main(String[] args) {
        log.trace("args is {}", Arrays.toString(args));
        log.trace("args.length is {}", args.length);

        try {
            String arg1 = args[0];
            String arg2 = args[1];

            int num = Integer.parseInt(arg1);
            int den = Integer.parseInt(arg2);

            int quo = num/den;
            int rem = num%den;
            log.trace("{} / {} = {}", num, den, quo);
            log.trace("{} % {} = {}", num, den, rem);
        } catch (Exception e) {
            // Exception being a superclass for all other exception types,
            // the variable "e" can collect any object thrown in the try block
            log.trace("There was an error - {}", e.getMessage());
        }

        log.trace("End of main() reached");
    }
}
