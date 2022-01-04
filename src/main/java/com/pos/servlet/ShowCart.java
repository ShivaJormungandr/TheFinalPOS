package com.pos.servlet;

import com.pos.bean.ProductBean;
import com.pos.entity.Product;
import com.pos.utility.Cart;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowCart", urlPatterns = {"/ShowCart"})
public class ShowCart extends HttpServlet {

    @Inject
    ProductBean productBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Product> productsInCart = null;
        System.out.println(request.getParameter("quantity"));
        if (request.getParameter("quantity") != null && request.getParameter("productId") != null) {
             
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int productId = Integer.parseInt(request.getParameter("productId"));
            System.out.println(quantity);
                        System.out.println(productId);

            Product productToAdd = productBean.findById(productId);

            Cart.getInstance().enterItem(productToAdd, quantity);
            
            productsInCart = Cart.getInstance().getProductsInCart();
        }
        
        if (Cart.getInstance().getProductsInCart() != null){
            productsInCart = Cart.getInstance().getProductsInCart();
        }
        
        request.setAttribute("productsInCart", productsInCart);
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
