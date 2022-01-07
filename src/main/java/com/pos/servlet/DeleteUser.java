package com.pos.servlet;

import com.pos.bean.UserBean;
import com.pos.entity.UserTable;
import com.pos.utility.LoggedUsers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DeleteUser", urlPatterns = {"/DeleteUser"})
public class DeleteUser extends HttpServlet {
    @Inject
    UserBean userBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        UserTable user = null;
        
        try{
            user = userBean.getById(id);
            System.out.println(user);
            //userBean.deleteUsersByIds(user);
            request.setAttribute("delete_msg", "User " + user + " has been deleted!");
            List<UserTable> users = userBean.getAllUsers();
            request.setAttribute("allUsers", users);
            request.setAttribute("loggedUser", LoggedUsers.getInstance().getLoggedUserById(id).getFullname());
            request.getRequestDispatcher("/WEB-INF/pages/adminView.jsp").forward(request, response);
        }catch(Exception ex){
            ex.printStackTrace();
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
