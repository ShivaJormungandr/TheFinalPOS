package com.pos.utility;

import com.pos.entity.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> productsInCart = null;
    
    private int cashierId;
    
    public Cart(){
        
    }
    
    public Cart(int cashierId){
        setCashierId(cashierId);
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }
    
    public void enterItem(Product product, int quantity) {
        if (productsInCart == null) {
            productsInCart = new ArrayList<Product>();
        }
        
        for (int i = 0; i < quantity; i++) {
            productsInCart.add(product);
        }
    }
    
    public void clearCart() {
        productsInCart.clear();
    }
    
    public int getCashierId(){
        return cashierId;
    }

    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }
    
    @Override
    public String toString(){
        return "Sunt un carut cu cashierId " + cashierId;
    }
}