package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditCategory", urlPatterns = {"/EditCategory"})
public class EditCategory extends HttpServlet {

    @Inject
    CategoryBean categoryBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int loggedId = Integer.parseInt(request.getParameter("loggedUserId"));
        
        Category category = categoryBean.findById(categoryId);
        
        request.setAttribute("category", category);
        request.setAttribute("loggedId", loggedId);
        
        request.getRequestDispatcher("/WEB-INF/pages/editCategory.jsp").forward(request, response);
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
