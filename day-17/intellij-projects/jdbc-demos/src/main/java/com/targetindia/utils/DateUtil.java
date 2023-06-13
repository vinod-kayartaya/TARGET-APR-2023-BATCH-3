package com.targetindia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static String toString(Date dt){
        if(dt==null){
            return "";
        }
        return sdf.format(dt);
    }

    public static Date toDate(String dt){
        try {
            return sdf.parse(dt);
        } catch (ParseException e) {
            return null;
        }
    }

}
