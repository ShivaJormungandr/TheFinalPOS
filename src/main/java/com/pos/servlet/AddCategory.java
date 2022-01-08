/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.bean.ProductBean;
import com.pos.bean.UserBean;
import com.pos.entity.Category;
import com.pos.entity.Product;
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
@WebServlet(name = "AddCategory", urlPatterns = {"/AddCategory"})
public class AddCategory extends HttpServlet {

    @Inject
    CategoryBean categoryBean;

    @Inject
    UserBean userBean;

    @Inject
    ProductBean productBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int loggedId = Integer.parseInt(request.getParameter("loggedUserId"));

        boolean needsEdit = false;

        if (request.getParameter("action") != null) {
            needsEdit = true;
        }

        if (needsEdit) {
            int categoryIdToUpdate = Integer.parseInt(request.getParameter("categoryId"));

            Category categoryToUpdate = categoryBean.findById(categoryIdToUpdate);

            for (Category category : categoryBean.getAllCategories()) {
                if (category.getCategory().equals(name)) {
                    response.sendRedirect("http://localhost:8080/TheFinalPOS/EditCategory?categoryId=" + categoryIdToUpdate + "&loggedUserId=" + loggedId);
                    return;
                }
            }

            List<Product> products = productBean.getAllProductsByCategory(categoryToUpdate);
            if (products.isEmpty()) {
                categoryBean.updateCategory(categoryToUpdate, name);
                response.sendRedirect("http://localhost:8080/TheFinalPOS/View?userId=" + loggedId);
            } else {
                response.sendRedirect("http://localhost:8080/TheFinalPOS/EditCategory?categoryId=" + categoryIdToUpdate + "&loggedUserId=" + loggedId);

            }

            return;
        }

        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("loggedUser", userBean.getById(loggedId));
            request.getRequestDispatcher("/WEB-INF/pages/addCategory.jsp").forward(request, response);
            return;
        }

        try {
            categoryBean.findByName(name);
            request.setAttribute("err_msg", "Category already exists!");
            request.getRequestDispatcher("/WEB-INF/pages/addCategory.jsp").forward(request, response);
        } catch (Exception ex) {
            categoryBean.createCategory(name);
            response.sendRedirect("http://localhost:8080/TheFinalPOS/View?userId=" + loggedId);
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
    }// </editor-fold>

}
