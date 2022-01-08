/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.bean.ProductBean;
import com.pos.bean.UnitBean;
import com.pos.bean.UserBean;
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
    UserBean userBean;

    @Inject
    CategoryBean categoryBean;

    @Inject
    UnitBean unitBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");

        double price = Double.parseDouble(request.getParameter("price") == null ? "0" : request.getParameter("price"));
        String unit = request.getParameter("unit");
        String imgPath = request.getParameter("imgPath");

        int loggedUserId = Integer.parseInt(request.getParameter("loggedUserId"));

        boolean needsEdit = false;

        if (request.getParameter("action") != null) {
            needsEdit = true;
        }

        if (needsEdit) {
            int productIdToUpdate = Integer.parseInt(request.getParameter("productId"));

            Product productToUpdate = productBean.findById(productIdToUpdate);

            productBean.updateProduct(productToUpdate, name, categoryBean.findByName(category), price, unitBean.findByName(unit), imgPath);
            response.sendRedirect("http://localhost:8080/TheFinalPOS/View?userId=" + loggedUserId);
            return;
        }
        if (name == null || name == "") {
            List<Category> categories = categoryBean.getAllCategories();
            List<Unit> units = unitBean.getAllUnits();
            request.setAttribute("categories", categories);
            request.setAttribute("units", units);
            request.setAttribute("loggedUser", userBean.getById(loggedUserId));
            request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
        }

        try {
            productBean.findByName(name);
            List<Category> categories = categoryBean.getAllCategories();
            List<Unit> units = unitBean.getAllUnits();
            request.setAttribute("categories", categories);
            request.setAttribute("units", units);
            request.setAttribute("loggedUser", userBean.getById(loggedUserId));

            request.setAttribute("err_msg", "Item already in stock");
            request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
            return;
        } catch (Exception ex) {
        }

        productBean.createProduct(name, categoryBean.findByName(category), price, unitBean.findByName(unit), imgPath);

        Product prod = productBean.findByName(name);
        prod.setImgPath(imgPath);

        List<Category> categories = categoryBean.getAllCategories();
        List<Unit> units = unitBean.getAllUnits();
        request.setAttribute("categories", categories);
        request.setAttribute("units", units);
        request.setAttribute("succes_msg", "Item added to the stock!");
        request.setAttribute("loggedUser", userBean.getById(loggedUserId));

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
