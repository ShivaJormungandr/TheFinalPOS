package com.pos.utility;

import com.pos.cartstate.AddingProducts;
import com.pos.cartstate.CartState;
import com.pos.cartstate.EmptyCart;
import com.pos.cartstate.PaymentEnded;
import com.pos.entity.Product;
import java.util.ArrayList;
import java.util.List;

public final class Cart{

    CartState empty;
    CartState addingProducts;
    CartState paymentEnded;
    
    CartState currentState;

    CartType cartType;
    
    private List<Product> productsInCart = null;

    private int cashierId;

    public Cart() {

    }

    public Cart(int cashierId, CartType cartType) {
        empty = new EmptyCart(this);
        addingProducts = new AddingProducts(this);
        paymentEnded = new PaymentEnded(this);

        currentState = empty;
        this.cartType = cartType;
        
        currentState.initializeCart(cashierId);
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void enterItems(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            enterItem(product);
        }
    }
    
    public void enterItem(Product product) {
        currentState.enterItem(product);
    }
    
    
    public void initialize(int cashierId) {
        this.cashierId = cashierId;
        productsInCart = new ArrayList();
    }

    public void removeItem(Product product) {
        currentState.removeItem(product);
    }

    public void clearCart() {
        productsInCart = null;
    }
    
    public void proceedPayment(){
        currentState.proceedPayment();
    }

    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }
    
    public void setCartState(CartState state) {
        currentState = state;
    }
    
    public CartState getCartState(){
        return currentState;
    }

    public CartState getEmptyState() {
        return empty;
    }

    public CartState getAddingProductsState() {
        return addingProducts;
    }

    public CartState getPaymentEndedState() {
        return paymentEnded;
    }
    
    public CartType getCartType() {
        return cartType;
    }

    @Override
    public String toString() {
        return "Sunt un carut cu cashierId " + cashierId;
    }

}
