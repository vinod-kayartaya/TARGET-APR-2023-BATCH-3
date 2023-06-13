package com.targetindia.utils;

public final class LineUtil {
    private LineUtil() {
    }

    public static void line() {
        line("-", 88);
    }

    public static void line(String pattern) {
        line(pattern, 88);
    }

    public static void line(int len){
        line("-", len);
    }


    public static void line(String pattern, int len) {
        len /= pattern.length();
        for (int i = 0; i < len; i++) {
            System.out.print(pattern);
        }
        System.out.println();
    }
}
