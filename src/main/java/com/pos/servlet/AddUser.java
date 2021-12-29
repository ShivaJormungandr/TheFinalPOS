/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.UserBean;
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

/**
 *
 * @author petel
 */
@WebServlet(name = "AddUser", urlPatterns = {"/AddUser"})
public class AddUser extends HttpServlet {
    @Inject
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String role = request.getParameter("role");
        String email = request.getParameter("email");

        userBean.CreateUser(username, password, fullName, role, email);

        List<UserTable> allUsers = userBean.getAllUsers();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddUser</title>");
            out.println("</head>");
            out.println("<body>");           
            
            out.println("<table>");
            out.println("<tr> <th>ID</th> <th>USERNAME</th> <th>FULLNAME</th> <th>PASSWORD</th>" + " <th>ID_ROLE</th> <th>ID_STATE</th> <th>EMAIL</th> </tr>");
            if (allUsers.isEmpty()) {
                out.println("<h1> No users found </h1>");
            } else {
                for (UserTable user : allUsers) {
                    out.println("<tr>" + "<td>" + user.getId() + "</td>" + "<td>" + user.getUsername() + "</td>" + "<td>" + user.getFullname() + "</td>"
                            + "<td>" + user.getPassword() + "</td>" + "<td>" + user.getIdRole() + "</td>"
                            + "<td>" + user.getIdState() + "</td>" + "<td>" + user.getEmail() + "</td>" + "</tr>");
                }
            }
            out.println("</table>");
           
            out.println("</body>");
            out.println("</html>");
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
