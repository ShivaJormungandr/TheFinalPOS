/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.ProductBean;
import com.pos.bean.UserBean;
import com.pos.entity.Product;
import com.pos.entity.UserTable;
import com.pos.utility.LoggedUsers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteProduct", urlPatterns = {"/DeleteProduct"})
public class DeleteProduct extends HttpServlet {
    
    @Inject
    ProductBean productBean;
    
    @Inject
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int loggedAdminId = Integer.parseInt(request.getParameter("loggedUserId"));
        
        Product product = null;
        
        try{
            product = productBean.findById(id);
            productBean.deleteProduct(product);
            request.setAttribute("delete_msg", "Product " + product + " has been deleted!");
            response.sendRedirect("http://localhost:8080/TheFinalPOS/View?userId=" + loggedAdminId);
        }catch(Exception ex){
            ex.printStackTrace();
        }
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
