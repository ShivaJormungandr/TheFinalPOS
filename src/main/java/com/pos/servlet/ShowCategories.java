package com.pos.servlet;

import com.pos.bean.CategoryBean;
import com.pos.entity.Category;
import com.pos.utility.CartType;
import com.pos.utility.CurrentCarts;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowCategories", urlPatterns = {"/ShowCategories"})
public class ShowCategories extends HttpServlet {

    @Inject
    CategoryBean categoryBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String actionType = request.getParameter("action");
        int cashierId = Integer.parseInt(request.getParameter("cashierId"));
        List<Category> categories =  categoryBean.getAllCategories();
        
        CartType cartType = CartType.valueOf(actionType);
      
        CurrentCarts.getInstance().createNewCartForCashier(cashierId,cartType);
        
        request.setAttribute("allCategories", categories);
        request.setAttribute("action", actionType);
        request.setAttribute("cashierId", cashierId);
        if (request.getParameter("err_product") != null){
            request.setAttribute("err_product", request.getParameter("err_product"));
        }

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
