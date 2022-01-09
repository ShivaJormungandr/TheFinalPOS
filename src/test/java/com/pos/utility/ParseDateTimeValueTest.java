package com.pos.utility;

import com.pos.entity.Product;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ParseDateTimeValueTest {
    
    public ParseDateTimeValueTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    @org.junit.jupiter.api.Test
    public void testParseTimestamp() {
        System.out.println("Parse Timestamp Test");
        
        String timestamp = "2020-10-12 00:00:00";
        Timestamp expResult = Timestamp.valueOf("2020-10-12 00:00:00");
        Timestamp result = ParseDateTimeValue.parseTimestamp(timestamp);
        
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testParseDate() throws Exception {
        System.out.println("Parse Date Test");
        
        String dateString = "2020-10-12";
        Date expResult = Date.valueOf(dateString);
        Date result = ParseDateTimeValue.parseDate(dateString);
        
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testFromStringDateToTimestamp() {
        System.out.println("From String Date To Timestamp Test");
        
        String dateString = "2020-10-12";
        String expResult = "2020-10-12 00:00:00.0";
        String result = ParseDateTimeValue.fromStringDateToTimestamp(dateString);
        
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testRoundToTwoDecimals() {
        System.out.println("Round To Two Decimals Test");
        
        Double value = 1.895;
        Double expResult = 1.90;
        Double result = ParseDateTimeValue.roundToTwoDecimals(value);
        
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testComputeTotalSumOfCart() {
        System.out.println("Compute Total Sum Of Cart");
        
        List<Product> productsInCart = new ArrayList<>();
        Product product1 = new Product();
        product1.setPrice(2.33);
        productsInCart.add(product1);
        
        Product product2 = new Product();
        product2.setPrice(2.55);
        productsInCart.add(product2);
        
        Double expResult = 4.88;
        Double result = ParseDateTimeValue.computeTotalSumOfCart(productsInCart);
        
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testComputeTaxes() {
        System.out.println("Compute Taxes Test");
        
        Double value = 10.2;
        Double taxPercentage = 0.19;
        Double expResult = 1.94;
        Double result = ParseDateTimeValue.computeTaxes(value, taxPercentage);
        
        assertEquals(expResult, result, 0.001);

    }
    
}
