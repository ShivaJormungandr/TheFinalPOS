/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.entity.Category;
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
 * @author adrian.larionescu
 */
@WebServlet(name = "ShowCategories", urlPatterns = {"/ShowCategories"})
public class ShowCategories extends HttpServlet {

    @Inject
    CategoryBean categoryBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String actionType = request.getParameter("action");
        List<Category> categories =  categoryBean.getAllCategories();
        
        // here will be cart Type set (sale, rental, return), if () after actionType
        
        request.setAttribute("allCategories", categories);
        request.setAttribute("action", actionType);
        request.getRequestDispatcher("/WEB-INF/pages/categories.jsp").forward(request, response);
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
