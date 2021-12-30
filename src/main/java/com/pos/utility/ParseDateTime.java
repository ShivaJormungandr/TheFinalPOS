/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.utility;

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
        timestamp += " 00:00:00";
        Timestamp t = Timestamp.valueOf(timestamp);
        
        return t;
    }
    
    public static java.sql.Date parseDate(String dateString) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        java.util.Date dateJava = formatter.parse(dateString);
        java.sql.Date dateSQL = new java.sql.Date(dateJava.getTime());
        
        return dateSQL;
    }
}
