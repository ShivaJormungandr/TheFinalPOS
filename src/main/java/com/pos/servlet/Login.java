package com.pos.servlet;

import com.pos.bean.RoleBean;
import com.pos.bean.TransactionTypeBean;
import com.pos.bean.UserBean;
import com.pos.entity.UserTable;
import com.pos.utility.LoggedUsers;
import com.pos.utility.Password;
import java.io.IOException;
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
    
    @Inject
    TransactionTypeBean transactionTypeBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username == null || "".equals(username)) && (password == null || "".equals(password))) {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
        
        UserTable user = null;

        try {
            user = userBean.getByUsername(username);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("err_msg_user", "Invalid username.");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
        
//        System.out.println(user);
//        System.out.println(password);
        if (!user.getPassword().equals(Password.convertToSha256(password))) {
            request.setAttribute("err_msg_pass", "Passwords do not match");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } else {
            LoggedUsers.getInstance().addLoggedUser(user);

            response.sendRedirect("http://localhost:8080/TheFinalPOS/View?userId=" + user.getId());
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
