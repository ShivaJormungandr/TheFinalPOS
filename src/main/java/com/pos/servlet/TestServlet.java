/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author Tavi
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    @Inject
    UserBean userBean;
    @Inject
    RoleBean roleBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<UserTable> allUsers = userBean.getAllUsers();
        Role roleById = roleBean.findById(1);
        Role roleByName = roleBean.findByName("Admin");

        List<Role> allRolesStart = roleBean.getAllRoles();
        roleBean.createRole("TestRole");
        List<Role> allRolesAfterAdd = roleBean.getAllRoles();
        Role tempRole = roleBean.findByName("TestRole");
        roleBean.updateRole(tempRole, "ReTestRole");
        List<Role> allRolesAfterUpdate = roleBean.getAllRoles();
        roleBean.deleteRole(tempRole);
        List<Role> allRolesAfterDelete = roleBean.getAllRoles();

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Servlet TestServlet at " + request.getContextPath() + "</p>");

            out.println("<table>");
            out.println("<tr> <th>ID</th> <th>USERNAME</th> <th>FULLNAME</th> <th>PASSWORD</th>"
                    + " <th>ID_ROLE</th> <th>ID_STATE</th> <th>EMAIL</th> </tr>");
            if (allUsers.isEmpty()) {
                out.println("<h1> No products right now! </h1>");
            } else {
                for (UserTable user : allUsers) {
                    out.println("<tr>" + "<td>" + user.getId() + "</td>" + "<td>" + user.getUsername() + "</td>" + "<td>" + user.getFullname() + "</td>"
                            + "<td>" + user.getPassword() + "</td>" + "<td>" + user.getIdRole() + "</td>"
                            + "<td>" + user.getIdState() + "</td>" + "<td>" + user.getEmail() + "</td>" + "</tr>");
                }
            }
            out.println("</table>");

            out.println("<p> Role By Id </p>");
            out.println("<p>" + roleById + roleById.getRole() + "</p>");
            out.println("<p> Role Name </p>");
            out.println("<p>" + roleByName + roleByName.getRole() + "</p>");

            out.println("<p> All Roles at Start </p>");
            if (!allRolesStart.isEmpty()) {
                for (Role role : allRolesStart) {
                    out.println("<p>" + role + " " + role.getRole() + "</p>");
                }
            }
            out.println("<p> Roles after add </p>");
            if (!allRolesAfterAdd.isEmpty()) {
                for (Role role : allRolesAfterAdd) {
                    out.println("<p>" + role + " " + role.getRole() + "</p>");
                }
            }
            out.println("<p> Roles after update </p>");
            if (!allRolesAfterUpdate.isEmpty()) {
                for (Role role : allRolesAfterUpdate) {
                    out.println("<p>" + role + " " + role.getRole() + "</p>");
                }
            }
            out.println("<p> Roles after delete </p>");
            out.println("<p> Roles after update </p>");
            if (!allRolesAfterDelete.isEmpty()) {
                for (Role role : allRolesAfterDelete) {
                    out.println("<p>" + role + " " + role.getRole() + "</p>");
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
