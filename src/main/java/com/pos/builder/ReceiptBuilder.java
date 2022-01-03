package com.pos.builder;

import com.pos.entity.Product;
import com.pos.entity.UserTable;
import java.util.Date;
import java.util.List;

public class ReceiptBuilder implements Builder {
    private ReceiptType receiptType;
    private String title;
    private Integer id;
    private List<Product> products;
    private Double totalAmount;
    private Double taxesAmount;
    private Date date;
    private UserTable cashier;

    @Override
    public void setReceiptType(ReceiptType receiptType) {
        this.receiptType = receiptType;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public void setTaxesAmount(Double taxesAmount) {
        this.taxesAmount = taxesAmount;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void setCashier(UserTable cashier) {
        this.cashier = cashier;
    }
    
    public Receipt getResult(){
        return new Receipt(receiptType, title, id, products, totalAmount, taxesAmount, date, cashier);
    }
}
