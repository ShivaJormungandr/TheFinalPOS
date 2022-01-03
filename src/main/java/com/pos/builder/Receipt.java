package com.pos.builder;

import com.pos.entity.Product;
import com.pos.entity.UserTable;
import java.util.Date;
import java.util.List;

public class Receipt {
    private final ReceiptType receiptType;
    private final String title;
    private final Integer id;
    private final List<Product> products;
    private final Double totalAmount;
    private final Double taxesAmount;
    private final Date date;
    private final UserTable cashier;
    
    public Receipt(ReceiptType receiptType, String title, Integer id, List<Product> products, Double totalAmount, Double taxesAmount, Date date, UserTable cashier) {
        this.receiptType = receiptType;
        this.title = title;
        this.id = id;
        this.products = products;
        this.totalAmount = totalAmount;
        this.taxesAmount = taxesAmount;
        this.date = date;
        this.cashier = cashier;
    }
    
    public ReceiptType getReceiptType(){
        return receiptType;
    }
    
    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getTaxesAmount() {
        return taxesAmount;
    }

    public Date getDate() {
        return date;
    }

    public UserTable getCashier() {
        return cashier;
    }
}
