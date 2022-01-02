package com.pos.servlet;

import com.pos.bean.RoleBean;
import com.pos.bean.UserBean;
import com.pos.entity.Role;
import com.pos.entity.UserTable;
import com.pos.utility.LoggedUser;
import com.pos.utility.Password;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Inject
    UserBean userBean;

    @Inject
    RoleBean roleBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserTable user = null;

        if (username == null || username == "") {
            request.setAttribute("err_msg", "Invalid username.");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }

        try {
            user = userBean.getByUsername(username);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//!user.getPassword().equals(Password.convertToSha256(password))
        if (1 == 2) {
            request.setAttribute("err_msg", "Invalid password.");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } else {
            System.out.println(user);
            LoggedUser.setLoggedUser(user);

            Role userRole = user.getIdRole();
            System.out.println(userRole);

            request.setAttribute("user", user);

            if (userRole.equals(roleBean.findByName("Cashier"))) {
                System.out.println("blaaa");
                request.getRequestDispatcher("/WEB-INF/pages/cashierView.jsp").forward(request, response);
            } else if (userRole.equals(roleBean.findByName("Director"))) {
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            } else if (userRole.equals(roleBean.findByName("Admin"))) {
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }

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
