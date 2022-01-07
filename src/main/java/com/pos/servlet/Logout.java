package com.pos.servlet;

import com.pos.bean.UserBean;
import com.pos.utility.LoggedUsers;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {

    @Inject
    UserBean userBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int loggedUserId = Integer.parseInt(request.getParameter("loggedUserId"));
        
        if (LoggedUsers.getInstance().getLoggedUserById(loggedUserId) != null){
            LoggedUsers.getInstance().logoutUser(userBean.getById(loggedUserId));
            response.sendRedirect("http://localhost:8080/TheFinalPOS/");
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
    }

}
