package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ExceptionDemo4 {
    public static void main(String[] args) {
        log.trace("args is {}", Arrays.toString(args));
        log.trace("args.length is {}", args.length);

        try {
            String arg1 = args[0];
            String arg2 = args[1];

            int num = Integer.parseInt(arg1); // not catching NumberFormatException
            int den = Integer.parseInt(arg2); // and there is no fallback catch section

            int quo = num / den;
            int rem = num % den;
            log.trace("{} / {} = {}", num, den, quo);
            log.trace("{} % {} = {}", num, den, rem);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.warn("Expected 2 inputs, but got {}", args.length);
            return; // takes the control out of main(), skipping the last log printing "End of main() reached"
        } catch (ArithmeticException e) {
            log.warn("Cannot divide {} by 0", args[0]);
            System.exit(1); // SOS - exit immediately, no time for any cleanup
        } finally {
            // this is block that is executed always (except when calling System.exit)
            log.trace("executing the `finally` block");
        }

        log.trace("End of main() reached");
    }
}
