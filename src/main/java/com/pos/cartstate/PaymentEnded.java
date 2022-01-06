package com.pos.cartstate;

import com.pos.entity.Product;
import com.pos.utility.Cart;

public class PaymentEnded implements CartState {

    Cart cart;

    public PaymentEnded(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void initializeCart(int cashierId) {
        System.out.println("A new sale will begin!");
        cart.setCartState(cart.getEmptyState());
        cart.initialize(cashierId);
    }

    @Override
    public void enterItem(Product product) {
        System.out.println("Payment already done.");
    }

    @Override
    public void removeItem(Product product) {
        System.out.println("Payment already done.");
    }

    @Override
    public void proceedPayment() {
        System.out.println("Payment already done.");
    }

}
