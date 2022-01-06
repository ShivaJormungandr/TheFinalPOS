package com.pos.cartstate;

import com.pos.entity.Product;
import com.pos.utility.Cart;

public class AddingProducts implements CartState {

    Cart cart;

    public AddingProducts(Cart cart) {
        this.cart = cart;
    }
    
    @Override
    public void initializeCart(int cashierId) {
        System.out.println("Cart already initialized!");
    }

    @Override
    public void enterItem(Product product) {
        cart.getProductsInCart().add(product);
        System.out.println("Added product " + product);

    }

    @Override
    public void removeItem(Product product) {
        cart.getProductsInCart().remove(product);
        System.out.println("Removed product from cart " + product);
        
        if (cart.getProductsInCart().isEmpty()){
            cart.setCartState(cart.getEmptyState());
            System.out.println("Went in empty state.");
        }
    }

    @Override
    public void proceedPayment() {
        System.out.println("Paying...");
        cart.setCartState(cart.getPaymentEndedState());
        cart.clearCart();
        System.out.println("Proceed payment");
    }
    
}
