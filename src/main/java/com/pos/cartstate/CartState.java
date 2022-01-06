package com.pos.cartstate;

import com.pos.entity.Product;

public interface CartState {
    void initializeCart(int cashierId);
    void enterItem(Product product);
    void removeItem(Product product);
    void proceedPayment();
}
