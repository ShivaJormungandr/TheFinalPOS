/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.utility;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import static javax.json.bind.JsonbConfig.DATE_FORMAT;

/**
 *
 * @author petel
 */
public class ParseDateTime {
 
    public static java.sql.Timestamp parseTimestamp(String timestamp) {
        Timestamp t = Timestamp.valueOf(timestamp);
        
        return t;
    }
}
