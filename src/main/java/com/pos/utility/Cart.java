package com.pos.utility;

import com.pos.bean.ProductBean;
import com.pos.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
//    public Sale getCurrentSale() {
//        return currentSale;
//    }

//    public void setCurrentSale(Sale currentSale) {
//        this.currentSale = currentSale;
//    }

//    private Sale currentSale;
//
//    public Register(ProductCatalog catalog) {
//        this.catalog = catalog;
//    }

//    public void endSale() {
//        currentSale.becomeComplete();
//    }

    public void enterItem(Product product, int quantity) {
        if (productsInCart == null) {
            productsInCart = new ArrayList<Product>();
        }
        
        System.out.println("the quantity is" + quantity + "!");    
        System.out.println("the product is " + product + "!");
        
        //System.out.println(productBean.findById(id));
       // Product product = productBean.findById(id);
//        System.out.println(product);
//        if (product == null) {
//            System.out.println("Item's id doesn't exist!");
//            return;
//        }
//    
        for (int i = 0; i < quantity; i++) {
            productsInCart.add(product);
        }
    }
    
    public void clearCart() {
        productsInCart.clear();
    }

//    public void makeNewSale() {
//        currentSale = new Sale();
//    }

//    public void makePayment(String paymentType, double cashTendered) {
//        currentSale.makePayment(cashTendered, paymentType);
//    }
}