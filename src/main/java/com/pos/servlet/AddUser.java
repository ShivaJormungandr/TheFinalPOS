/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.servlet;

import com.pos.bean.UserBean;
import com.pos.bean.RoleBean;
import com.pos.decorator.ConsoleDecorator;
import com.pos.entity.UserTable;
import com.pos.entity.Role;
import com.pos.observer.NotificationCenter;
import com.pos.utility.Notification;
import com.pos.utility.Password;
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
    @Inject
    RoleBean roleBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String retypePass = request.getParameter("retypePass");

        List<Role> roles = roleBean.getAllRoles();

        boolean needsEdit = request.getParameter("action").equals("edit");
        int loggedAdminId = Integer.parseInt(request.getParameter("loggedId"));

        if (needsEdit) {
            int userIdToUpdate = Integer.parseInt(request.getParameter("userId"));

            UserTable userToUpdate = userBean.getById(userIdToUpdate);

            if (username.equals(userToUpdate.getUsername())) {
                username = null;
            } else {
                try {
                    UserTable someUser = userBean.getByUsername(username);
                    request.setAttribute("err_msg_user", "User Taken");
                    request.setAttribute("roles", roles);
                    request.setAttribute("user", userToUpdate);
                    request.setAttribute("loggedId", loggedAdminId);

                    request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request, response);
                } catch (Exception ex) {
                    
                }
            }

            if (!password.equals("******")) {
                if (!password.equals(retypePass)) {
                    request.setAttribute("err_msg_pass", "Passwords do not match");
                    request.setAttribute("roles", roles);
                    request.setAttribute("user", userToUpdate);
                    request.setAttribute("loggedId", loggedAdminId);

                    request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request, response);
                } else {
                    password = Password.convertToSha256(password);
                }
            } else {
                password = null;
            }
            
            userBean.updateUser(userToUpdate, username, password, fullName, role, email, null);
            response.sendRedirect("http://localhost:8080/TheFinalPOS/View?userId=" + loggedAdminId);

            return;
        }

        UserTable user = null;

        if (!password.equals(retypePass)) {
            request.setAttribute("err_msg_pass", "Passwords do not match");
            request.setAttribute("roles", roles);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }

        try {
            user = userBean.getByUsername(username);
            request.setAttribute("err_msg_user", "User Taken");
            request.setAttribute("roles", roles);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        } catch (Exception ex) {
            userBean.CreateUser(username, password, fullName, role, email);

            Notification.notificationCount++;
            if (Notification.events != null) {
                Notification.events.notify("New registered user is pending approval...");
            }

            if (Notification.decoratorEvents == null) {
                Notification.decoratorEvents = new ConsoleDecorator();
                Notification.decoratorEvents.notify("New registered user is pending approval...");
            }

            List<UserTable> users = userBean.getAllUsers();
            request.setAttribute("allUsers", users);
            request.setAttribute("loggedUser", fullName);
            request.getRequestDispatcher("/WEB-INF/pages/adminView.jsp").forward(request, response);
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
