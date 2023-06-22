package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;

@Slf4j
public class CalendarInformation {
    public static void main(String[] args) {
        Calendar dt = Calendar.getInstance();
        // change dt to 3/4/2012
        dt.set(1974, 3, 3); // month starts from 0 for January, 1 for Feb, etc
        log.trace("today is {}", dt);

        String[] months = {"January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        String[] weekdays = {
                "", "Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"
        };

        log.trace("{}", dt);
        int m = dt.get(Calendar.MONTH);
        int wd = dt.get(Calendar.DAY_OF_WEEK);
        log.trace("We are in the month of {}", months[m]);
        log.trace("Today is a {}", weekdays[wd]);
    }
}
