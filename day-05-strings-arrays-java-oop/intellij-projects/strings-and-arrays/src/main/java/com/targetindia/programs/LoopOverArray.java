package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class LoopOverArray {
    public static void main(String[] args) {
        String[] weekdays = {
                "Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"
        };

        log.trace("weekdays = {}", Arrays.toString(weekdays));

        for (int i = 0; i < weekdays.length; i++) {
            log.trace("weekdays[{}] = {}", i, weekdays[i]);
        }

        for(String day: weekdays) {
            log.trace("day is {}", day);
        }
    }
}
