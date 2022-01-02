package com.pos.servlet;

import com.pos.bean.TransactionBean;
import com.pos.bean.TransactionTypeBean;
import com.pos.bean.UserBean;
import com.pos.entity.Product;
import com.pos.entity.TransactionTable;
import com.pos.utility.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcessSale", urlPatterns = {"/ProcessSale"})
public class ProcessSale extends HttpServlet {

    @Inject
    UserBean userBean;
    
    @Inject
    TransactionBean transactionBean;
    
    @Inject
    TransactionTypeBean transactionTypeBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Product> productsInCart = Cart.getInstance().getProductsInCart();
        double sum = productsInCart.stream().mapToDouble(p -> p.getPrice()).sum();
        System.out.println(sum);
        
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        TransactionTable currentTransaction = transactionBean.createTransaction(date, transactionTypeBean.findByName("Sale"), userBean.getByUsername("andrei"), null);
        
        transactionBean.addProductsToTransaction(currentTransaction, productsInCart);
        Cart.getInstance().clearCart();
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
