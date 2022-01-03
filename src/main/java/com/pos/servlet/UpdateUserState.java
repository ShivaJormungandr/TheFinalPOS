package com.pos.servlet;

import com.pos.bean.StateBean;
import com.pos.bean.UserBean;
import com.pos.entity.UserTable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateUserState", urlPatterns = {"/UpdateUserState"})
public class UpdateUserState extends HttpServlet {

    @Inject
    UserBean userBean;
    
    @Inject
    StateBean stateBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer userId = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");
      
        UserTable userToUpdate = userBean.getById(userId);
        userBean.updateUser(userToUpdate, null, null, null, null, null, action);
        
        response.sendRedirect("http://localhost:8080/TheFinalPOS/Login");
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
