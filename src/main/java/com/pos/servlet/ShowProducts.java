/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.bean.ProductBean;
import com.pos.bean.UnitBean;
import com.pos.entity.Category;
import com.pos.entity.Product;
import com.pos.utility.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tavi
 */
@WebServlet(name = "ShowProducts", urlPatterns = {"/ShowProducts"})
public class ShowProducts extends HttpServlet {

    @Inject
    ProductBean productBean;
    @Inject
    CategoryBean categoryBean;
    @Inject
    UnitBean unitBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //List<Product> allProducts = productBean.getAllProducts();
                System.out.println("trece prin servlet");
        String categoryName = request.getParameter("category");
        int cashierId = Integer.parseInt(request.getParameter("cashierId"));
        
        
        System.out.println(categoryName);
        Category category = categoryBean.findByName(categoryName);
//        Cart cart = new Cart();
        List<Product> productsByCategory = productBean.getAllProductsByCategory(category);
        request.setAttribute("products", productsByCategory);
        request.setAttribute("cashierId", cashierId);
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
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
