package com.pos.utility;

import java.util.ArrayList;
import java.util.List;

public class CurrentCarts {

    private static List<Cart> carts = new ArrayList<Cart>();

    private static CurrentCarts currentCarts = null;

    private CurrentCarts() {

    }

    public static CurrentCarts getInstance() {
        if (currentCarts == null) {
            currentCarts = new CurrentCarts();
        }

        return currentCarts;
    }

    public boolean doesCashierHaveCart(int cashierId) {
        for (Cart cart : carts) {
                if (cart.getCashierId() == cashierId) {
                    return true;
                }
            }

        return false;
    }
    
    public void createNewCartForCashier(int cashierId){
        Cart cart = new Cart(cashierId);

        carts.add(cart);
    }
    
    public Cart getCartByCashierId(int cashierId) {
        if (doesCashierHaveCart(cashierId)) {
            for (Cart cart : carts) {
                if (cart.getCashierId() == cashierId) {
                    return cart;
                }
            }
        }

        return null;
    }

}
