package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class StringBuilderDemo {

    public static void main(String[] args) {
        String name = "Vinod";
        name.toUpperCase(); // creates a new String containing the uppercase version of "name", and returns the same
        log.trace("name is '{}'", name);
        name = name.toUpperCase(); // name now refers to a different object
        log.trace("name is '{}'", name);

        String text = "";
        text += "hello";
        text += " and";
        text += " welcome";
        text += " to";
        text += " java";
        text += " training.";

        log.trace(text);

        int i = 123;
        double d = 34.5;
        boolean b = false;

        StringBuilder sb = new StringBuilder(1000);
        sb.append("value of i is ")
                .append(i)
                .append(", value of d is ")
                .append(d)
                .append(" and value of b is ")
                .append(b);

        text = sb.toString();
        log.trace(text);

        // the above is similar to this:
        text = "value of i is " + i + ", value of d is " + d + " and value of b is " + b;
        // but creates and discards multiple String objects, which is less performing.

        log.trace(text);

    }
}
