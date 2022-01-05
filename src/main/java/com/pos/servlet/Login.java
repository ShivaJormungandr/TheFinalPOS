package com.pos.servlet;

import com.pos.bean.RoleBean;
import com.pos.bean.TransactionTypeBean;
import com.pos.bean.UserBean;
import com.pos.entity.Role;
import com.pos.entity.TransactionType;
import com.pos.entity.UserTable;
import com.pos.observer.BrowserNotificationListener;
import com.pos.utility.LoggedUser;
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

        UserTable loggedUser = LoggedUser.getLoggedUser();
        if (loggedUser != null) {
            request.setAttribute("user", loggedUser);
            redirectRole(loggedUser, request, response);
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username == null || username == "") && (password == null || password == "")) {
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
        
        System.out.println(user);
        System.out.println(password);
        if (!user.getPassword().equals(Password.convertToSha256(password))) {
            request.setAttribute("err_msg_pass", "Passwords do not match");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        } else {
            System.out.println(user);
            LoggedUser.setLoggedUser(user);

            Role userRole = user.getIdRole();
            System.out.println(userRole);

            request.setAttribute("user", user);

            redirectRole(user, request, response);
        }
    }

    private void redirectRole(UserTable user, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (user.getIdRole().equals(roleBean.findByName("Cashier"))) {
            List<TransactionType> types = transactionTypeBean.getAllCategories();
            request.setAttribute("types", types);
            request.getRequestDispatcher("/WEB-INF/pages/cashierView.jsp").forward(request, response);
        } else if (user.getIdRole().equals(roleBean.findByName("Director"))) {
            BrowserNotificationListener listener = new BrowserNotificationListener(user.getId());
            Notification.events.attach(listener);
            List<UserTable> users = userBean.getAllUsers();
            request.setAttribute("allUsers", users);
            request.setAttribute("loggedUser", user.getFullname());
            request.getRequestDispatcher("/WEB-INF/pages/directorView.jsp").forward(request, response);
        } else if (user.getIdRole().equals(roleBean.findByName("Admin"))) {
            List<UserTable> users = userBean.getAllUsers();
            request.setAttribute("allUsers", users);
            request.setAttribute("loggedUser", user.getFullname());
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
