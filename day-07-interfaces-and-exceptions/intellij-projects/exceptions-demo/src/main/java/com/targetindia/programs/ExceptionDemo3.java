package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ExceptionDemo3 {
    public static void main(String[] args) {
        log.trace("args is {}", Arrays.toString(args));
        log.trace("args.length is {}", args.length);

        try {
            String arg1 = args[0];
            String arg2 = args[1];

            int num = Integer.parseInt(arg1);
            int den = Integer.parseInt(arg2);

            int quo = num / den;
            int rem = num % den;
            log.trace("{} / {} = {}", num, den, quo);
            log.trace("{} % {} = {}", num, den, rem);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.warn("Expected 2 inputs, but got {}", args.length);
        } catch (NumberFormatException e) {
            log.warn("Expected 2 integers, but got [{}, {}]", args[0], args[1]);
        } catch (ArithmeticException e) {
            log.warn("Cannot divide {} by 0", args[0]);
        } catch (Exception e){
            // default handler / fallback catch
            log.warn("There wan error", e);
            // notice that we didn't use {}, will print the entire stacktrace
        }

        log.trace("End of main() reached");
    }
}
