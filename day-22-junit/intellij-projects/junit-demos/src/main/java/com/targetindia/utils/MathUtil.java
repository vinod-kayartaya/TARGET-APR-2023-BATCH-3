package com.targetindia.utils;


public class MathUtil {

    public double addAll(Object... args) {
        // this method should add all numbers and strings containing numbers
        // any other data types are encountered, we must throw an exception
        // if the string is not a numerical representation, then throw an exception
        double sum = 0;

        for (Object arg : args) {
            if (arg instanceof Byte) {
                sum += ((Byte) arg).byteValue();
            } else if (arg instanceof Short) {
                sum += ((Short) arg).shortValue();
            } else if (arg instanceof Integer) {
                sum += ((Integer) arg).intValue();
            } else if (arg instanceof Long) {
                sum += ((Long) arg).longValue();
            } else if (arg instanceof Float) {
                sum += ((Float) arg).floatValue();
            } else if (arg instanceof Double) {
                sum += ((Double) arg).doubleValue();
            } else if (arg instanceof String) {
                try {
                    sum += Double.parseDouble((String) arg);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(e);
                }
            } else {
                throw new IllegalArgumentException("Incompatible data type");
            }
        }
        return sum;
    }

    public double power(int a, int b) {
        double p = 1;

        if (b < 0) {
            for (int i = 0; i < -b; i++) {
                p *= a;
            }
            return 1 / p;
        }

        for (int i = 0; i < b; i++) {
            p *= a;
        }

        return p;
    }

    public long factorial(int num) {
        long f = 1;
        for (int i = 2; i <= num; i++) {
            f *= i;
        }
        return f;
    }
}
