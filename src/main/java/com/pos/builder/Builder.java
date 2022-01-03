package com.pos.builder;

import com.pos.entity.Product;
import com.pos.entity.UserTable;
import java.util.Date;
import java.util.List;

public interface Builder {
    void setReceiptType(ReceiptType receiptType);
    void setTitle(String title);
    void setId(Integer id);
    void setProducts(List<Product> products);
    void setTotalAmount(Double totalAmount);
    void setTaxesAmount(Double taxesAmount);
    void setDate(Date date);
    void setCashier(UserTable cashier);
}
