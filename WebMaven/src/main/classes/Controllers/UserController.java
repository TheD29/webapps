package Controllers;

import db.DbConnector;

import javax.servlet.ServletException;
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

/**
 * Created by Dima on 30.03.2017.
 */
public class UserController extends HttpServlet {
    private static Connection conn;
    private static ResultSet rs;
    private static Statement stmt;

    private void validateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        {
            ResultSet rs = null;
            HttpSession session = request.getSession();

            String yName = request.getParameter("username");
            String yPassword = request.getParameter("password");

            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
//            if (yName.length() > 4 && yName.length() < 15)
                try {
                    Connection conn = DbConnector.getConnection();
                    Statement statement = conn.createStatement();

                    String sql = "SELECT * FROM magazine.users "
                            + "WHERE accountname ='" + yName + "' "
                            + "AND password = '" + yPassword + "'";
                    rs = statement.executeQuery(sql);
                    session.setAttribute("accountname", "loginAccess");
                    if (rs.next()) {
                        response.sendRedirect("pages/main.jsp");
                    } else {
                        session.setAttribute("login", "loginFailed");
                        response.sendRedirect("index.jsp");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
                }
//            else
//                pw.print("Логін не може бути менше 4 або більше 15 символів" + yName);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        validateUser(request, response);

    }
}

