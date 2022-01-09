package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.bean.ProductBean;
import com.pos.entity.Category;
import com.pos.entity.Product;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteCategory", urlPatterns = {"/DeleteCategory"})
public class DeleteCategory extends HttpServlet {
    
    @Inject
    CategoryBean categoryBean;
    
    @Inject
    ProductBean productBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int loggedAdminId = Integer.parseInt(request.getParameter("loggedUserId"));
        
        Category category = null;
        
        try{
            category = categoryBean.findById(id);
            for(Product product : productBean.getAllProducts()){
                if(product.getIdCategory().equals(category)){
                    response.sendRedirect("http://localhost:8080/TheFinalPOS/View?userId=" + loggedAdminId);
                    return;
                }
            }
            categoryBean.deleteCategory(category);
            response.sendRedirect("http://localhost:8080/TheFinalPOS/View?userId=" + loggedAdminId);
        }catch(Exception ex){}
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
