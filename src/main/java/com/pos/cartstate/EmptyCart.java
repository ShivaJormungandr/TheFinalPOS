package com.pos.cartstate;

import com.pos.entity.Product;
import com.pos.utility.Cart;

public class EmptyCart implements CartState {

    Cart cart;

    public EmptyCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void initializeCart(int cashierId) {
        cart.initialize(cashierId);
        System.out.println("Initialized cart for cashierId " + cashierId);
    }

    @Override
    public void enterItem(Product product) {
        cart.setCartState(cart.getAddingProductsState());
        System.out.println("Now in adding state");
        cart.enterItem(product);
    }

    @Override
    public void removeItem(Product product) {
        System.out.println("You cannot remove an item!!! The cart is empty!");
    }

    @Override
    public void proceedPayment() {
        System.out.println("What dafuq u want to buy?! The cart is empty!");
    }

}
