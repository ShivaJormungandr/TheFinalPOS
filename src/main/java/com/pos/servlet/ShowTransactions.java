/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.ProductBean;
import com.pos.bean.TransactionBean;
import com.pos.bean.TransactionTypeBean;
import com.pos.bean.UserBean;
import com.pos.entity.Product;
import com.pos.entity.TransactionTable;
import com.pos.utility.ParseDateTime;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author petel
 */
@WebServlet(name = "ShowTransactions", urlPatterns = {"/ShowTransactions"})
public class ShowTransactions extends HttpServlet {
    @Inject
    TransactionBean transactionBean;
    
    @Inject
    TransactionTypeBean transactionTypeBean;
    
    @Inject
    UserBean userBean;
    
    @Inject
    ProductBean productBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //COMMENTED PART IS FOR CREATING A NEW TRANSACTION (FOR TESTING PURPOSES, DON'T DELETE FOR NOW)
        /*
        java.sql.Date transactionDate = null;
        try {
            transactionDate = ParseDateTime.parseDate("2021-12-30");
        } catch (ParseException ex) {
            Logger.getLogger(ShowTransactions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        transactionBean.createTransaction(transactionDate, transactionTypeBean.findByName("Sale"), userBean.getByUsername("asd"), null);
        
        TransactionTable transaction = transactionBean.findById(7);
        Product product = productBean.findByName("Milk");
        
        transactionBean.addProductToTransaction(transaction, product);
        transactionBean.addProductToTransaction(transaction, product);
        
        product = productBean.findByName("Car");
        transactionBean.addProductToTransaction(transaction, product);
        
        
        TransactionTable transaction = transactionBean.findById(7);
        transactionBean.calculateTotalValue(transaction, transactionBean.getProductsFromTransaction(transaction));*/
        
        List<TransactionTable> allTransactions = transactionBean.getAllTransactions();
        //List<TransactionTable> allTransactions = transactionBean.getTransactionsBetweenValues(2700, 4500);
        //List<TransactionTable> allTransactions = transactionBean.getTransactionsBetweenDates("2021-12-01", "2021-12-31");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddUser</title>");
            out.println("</head>");
            out.println("<body>");           
            
            out.println("<table>");
            out.println("<tr> <th>ID</th> <th>TYPE</th> <th>VALUE</th> <th>CASHIER</th> <th>DATE</th> </tr>");
            if (allTransactions.isEmpty()) {
                out.println("<h1> No transactions found </h1>");
            } else {
                for (TransactionTable t : allTransactions) {
                    out.println("<tr>" + "<td>" + t.getId() + "</td>" + "<td>" + t.getIdType().getType() + "</td>" + "<td>" + t.getValue() + "</td>"
                            + "<td>" + t.getIdCashier().getUsername()  + "</td>" + "<td>" + t.getTransactionDate() + "</td>" + "</tr>");
                }
            }
            out.println("</table>");
           
            out.println("</body>");
            out.println("</html>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
