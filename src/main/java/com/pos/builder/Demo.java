package com.pos.builder;

import com.pos.entity.Product;
import com.pos.entity.UserTable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //BUILDER EXAMPLE
        /*List<Product> products = new ArrayList<Product>();
        products.add((new Product().setProductName("Lapte")));
        
        ReceiptBuilder builder = new ReceiptBuilder();
        builder.setReceiptType(ReceiptType.SIMPLE);
        builder.setId(1);
        builder.setTitle("SIMPLE: Multumim ca ati ales saptamana comunista Lidl!");
        builder.setProducts(products);
        builder.setTotalAmount(255.23);

        Receipt simpleReceipt = builder.getResult();
        System.out.println("Simple receipt built:\n" + simpleReceipt.getTitle());


        ReceiptBuilder builder2 = new ReceiptBuilder();

        builder2.setReceiptType(ReceiptType.COMPLEX);
        builder2.setId(2);
        builder2.setTitle("COMPLEX: Multumim ca ati ales saptamana comunista Lidl!");
        builder2.setProducts(products);
        builder2.setTotalAmount(255.23);
        builder2.setTaxesAmount(0.19 * 255.23);
        builder2.setDate(new Date("2020-12-12"));
        builder2.setCashier((new UserTable().setUsername("Marian")));

        Receipt complexReceipt = builder2.getResult();
        
        System.out.println("\nComplex receipt built:\n" + complexReceipt.getTitle());*/
    }
}
