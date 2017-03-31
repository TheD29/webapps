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

/**
 * Created by Dima on 30.03.2017.
 */
public class UserController extends HttpServlet {
    private static Connection conn;
    private static ResultSet rs;
    private static Statement stmt;

    private void validateUserValidate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        {
            ResultSet rs = null;
            HttpSession session = request.getSession();

            String yName = request.getParameter("username");
            String yPassword = request.getParameter("password");

            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            try {
                Connection conn = DbConnector.getConnection();
                Statement statement = conn.createStatement();

                String sql = "SELECT * FROM magazine.users "
                        + "WHERE accountname ='" + yName + "' "
                        + "AND password = '" + yPassword + "'";
                rs = statement.executeQuery(sql);
                session.setAttribute("accauntname", "loginAccess");
                if (rs.next()) {
                    response.sendRedirect("/pages/main.jsp");
                    // request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
                    //pw.print("Name" + rs.getString("firstname"));
                } else
                    pw.print("Логін або пароль не вірні");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        validateUserValidate(request, response);
    }
}


