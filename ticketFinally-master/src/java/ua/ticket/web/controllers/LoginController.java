package ua.ticket.web.controllers;

import ua.ticket.web.db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void checkLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ResultSet rs = null;
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String loginFailed = "login";

        String userLogin = request.getParameter("login");
        String userPassword = request.getParameter("password");
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
        ) {

            String sql = "SELECT login FROM tickets.users "
                    + "WHERE login ='" + userLogin + "' "
                    + "AND password ='" + userPassword + "' ";

            rs = stmt.executeQuery(sql);

            session.setAttribute("login", "loginAccess");
            if (rs.next()) {
                response.sendRedirect("pages/sale.jsp");
            } else {
                session.setAttribute("login", "loginFailed");
                response.sendRedirect("index.jsp");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkLogin(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkLogin(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "inline; filename=ALVList.html");
        response.setHeader("Cache-control", "");
        response.setHeader("Pragma", "");
        request.setCharacterEncoding("UTF-8");
        super.service(request, response); //To change body of generated methods, choose Tools | Templates.
    }
}
