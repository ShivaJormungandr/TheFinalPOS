/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.bean.ProductBean;
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
 * @author Tavi
 */
@WebServlet(name = "ShowProducts", urlPatterns = {"/ShowProducts"})
public class ShowProducts extends HttpServlet {

    @Inject
    ProductBean productBean;
    @Inject
    CategoryBean categoryBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Product> allProducts = productBean.getAllProducts();
        Category category = categoryBean.findByName("Food");

        List<Product> productsByCategory = productBean.getAllProductsByCategory(category);

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowProducts</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Servlet ShowProducts at " + request.getContextPath() + "</p>");

            out.println("<p> All Prod </p>");
            if (!allProducts.isEmpty()) {
                for (Product product : allProducts) {
                    out.println("<p>" + product + " " + product.getProductName() + "</p>");
                }
            }

            out.println("<p> All Prod od category" + category.getCategory() + " </p>");
            if (!productsByCategory.isEmpty()) {
                for (Product product : productsByCategory) {
                    out.println("<p>" + product + " " + product.getProductName() + "</p>");
                }
            }

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
