/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import static javax.json.bind.JsonbConfig.DATE_FORMAT;

/**
 *
 * @author petel
 */
public class ParseDateTime {

    public static java.sql.Timestamp parseTimestamp(String timestamp) {
        //timestamp += " 00:00:00";
        Timestamp t = Timestamp.valueOf(timestamp);

        return t;
    }

    public static java.sql.Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        java.util.Date dateJava = formatter.parse(dateString);
        java.sql.Date dateSQL = new java.sql.Date(dateJava.getTime());

        return dateSQL;
    }

    public static String fromStringDateToTimestamp(String dateString) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateJava = formatter.parse(dateString);
            Timestamp timestamp = new java.sql.Timestamp(dateJava.getTime());
            return timestamp.toString();
        } catch (Exception e) { //this generic but you can control another types of exception
            // look the origin of excption 
        }
        return null;
    }
    
    public static Double roundToTwoDecimals(Double val) {
        return new BigDecimal(val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
    }
}
