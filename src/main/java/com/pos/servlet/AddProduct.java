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
import com.pos.entity.Unit;
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
 * @author petel
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {
    @Inject
    ProductBean productBean;
    
    @Inject
    CategoryBean categoryBean;
    
    @Inject
    UnitBean unitBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String name = request.getParameter("name");
        if(name == null || name == ""){
            List<Category> categories = categoryBean.getAllCategories();
            List<Unit> units = unitBean.getAllUnits();
            request.setAttribute("categories", categories);
            request.setAttribute("units", units);
            request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
        }
        
        try{
            productBean.findByName(name);
            List<Category> categories = categoryBean.getAllCategories();
            List<Unit> units = unitBean.getAllUnits();
            request.setAttribute("categories", categories);
            request.setAttribute("units", units);
            request.setAttribute("err_msg", "Item already in stock");
            request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
            return;
        }catch(Exception ex){
        }
        
        String category = request.getParameter("category");
        
        double price = Double.parseDouble(request.getParameter("price") == null ? "0" : request.getParameter("price"));
        String unit = request.getParameter("unit");
        String imgPath = request.getParameter("imgPath");

        productBean.createProduct(name, categoryBean.findByName(category), price, unitBean.findByName(unit), imgPath);
        
        Product prod = productBean.findByName(name);
        prod.setImgPath(imgPath);
        
        List<Category> categories = categoryBean.getAllCategories();
        List<Unit> units = unitBean.getAllUnits();
        request.setAttribute("categories", categories);
        request.setAttribute("units", units);
        request.setAttribute("succes_msg", "Item added to the stock!");
        request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
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
