package com.pos.utility;

import com.pos.entity.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> productsInCart = null;
    
    private static Cart cart = null;
    
    private Cart(){
        
    }

    public static Cart getInstance()
    {
        if (cart == null)
            cart = new Cart();
 
        return cart;
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

}