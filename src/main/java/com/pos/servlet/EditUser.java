package com.pos.servlet;

import com.pos.bean.RoleBean;
import com.pos.bean.UserBean;
import com.pos.entity.Role;
import com.pos.entity.UserTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditUser", urlPatterns = {"/EditUser"})
public class EditUser extends HttpServlet {

    @Inject
    UserBean userBean;
    @Inject
    RoleBean roleBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int userId = Integer.parseInt(request.getParameter("userId"));
        int loggedId = Integer.parseInt(request.getParameter("loggedUserId"));
        
        UserTable user = userBean.getById(userId);
         
        List<Role> allRoles = roleBean.getAllRoles();
        request.setAttribute("roles", allRoles);
        request.setAttribute("user", user);
        request.setAttribute("loggedUser", userBean.getById(loggedId));
        
        request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request, response);
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
