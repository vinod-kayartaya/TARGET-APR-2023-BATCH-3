package com.targetindia.programs;

public class VariableDemo {
    public static void main(String[] args) {
        var distance = Double.valueOf(12.3);
        var username = "vinodkumar";
        var password = "topsecret";

        System.out.printf("data type of distance is %s%n", distance.getClass().getName());
        System.out.printf("data type of username is %s%n", username.getClass().getName());
        System.out.printf("data type of password is %s%n", password.getClass().getName());

        System.out.printf("range of values in `byte` type: %d to %d%n",
                Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("range of values in `short` type: %d to %d%n",
                Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("range of values in `int` type: %d to %d%n",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("range of values in `long` type: %d to %d%n",
                Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("range of values in `float` type: %s to %s%n",
                Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("range of values in `double` type: %s to %s%n",
                Double.MIN_VALUE, Double.MAX_VALUE);

        char ch = '\u0C95'; // kannada character 'ka' or 'ಕ'
        System.out.printf("ch is %c%n", ch);
    }
}
