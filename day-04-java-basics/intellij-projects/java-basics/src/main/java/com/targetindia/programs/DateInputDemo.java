package com.targetindia.programs;

import com.targetindia.utils.DateUtil;
import com.targetindia.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateInputDemo {

    public static void main1(String[] args) throws ParseException {
        Date dob = KeyboardUtil.getDate("Enter your date of birth: ");
        log.trace("dob = {}", dob);
    }
    public static void main2(String[] args) throws ParseException {
        String input;
        input = KeyboardUtil.getString("Enter your date of birth in dd/mm/yyyy format: ");
        Date dob = DateUtil.toDate(input);
        log.trace("dob = {}", dob);
    }

    public static void main(String[] args) throws ParseException {
        Date dt = new Date(); // creates a Date object initialized with current date/time
        log.trace("dt = {}", dt);

        SimpleDateFormat sdf = new SimpleDateFormat();
        log.trace("dt = {}", sdf.format(dt));

        sdf.applyPattern("yyyy-MM-dd");
        log.trace("dt = {}", sdf.format(dt));

        sdf.applyPattern("yyyy-MM-dd hh:mm:ss a");
        log.trace("dt ={}", sdf.format(dt));

        sdf.applyPattern("EEE MMM d, yyyy");
        log.trace("dt = {}", sdf.format(dt));

        sdf.applyPattern("EEEE MMMM d, yyyy hh:mm:ss a (z)");
        log.trace("dt = {}", sdf.format(dt));

        String dob = "20/01/1974";
        sdf.applyPattern("dd/MM/yyyy");
        sdf.setLenient(false); // set this to true (default) and try with 40/20/1974
        dt = sdf.parse(dob);
        log.trace("{}", dt);
    }
}
