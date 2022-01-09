package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.bean.ProductBean;
import com.pos.entity.Category;
import com.pos.entity.Product;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowStore", urlPatterns = {"/ShowStore"})
public class ShowStore extends HttpServlet {
    
    @Inject
    ProductBean productBean;
    
    @Inject
    CategoryBean categoryBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String categoryToFilterString = request.getParameter("category");
        
        List<Category> allCategories = categoryBean.getAllCategories();
        request.setAttribute("allCategories", allCategories);
        
        if (categoryToFilterString != null){
           Category categoryToFilter = categoryBean.findByName(categoryToFilterString);
           List<Product> productsByCategory = productBean.getAllProductsByCategory(categoryToFilter);
           request.setAttribute("allProducts", productsByCategory);
           request.getRequestDispatcher("/WEB-INF/pages/allProducts.jsp").forward(request, response);

        }
        
        List<Product> allProducts = productBean.getAllProducts();
        System.out.println(allProducts);
        request.setAttribute("allProducts", allProducts);
        
        request.getRequestDispatcher("/WEB-INF/pages/allProducts.jsp").forward(request, response);
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
