package Administrator.Controllers;

import Administrator.db.Connector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Administrator.db.Connector;


/**
 * Created by Dima on 23.03.2017..get
 */
public class LoginController extends HttpServlet implements ServletModel {
    @Override
    public void checkUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String uLogin = request.getParameter("username");
        String uPassword = request.getParameter("password");
        session.setAttribute("uSes", uLogin);
        response.sendRedirect("/main.jsp");

        ResultSet rs = null;



        Connector connector = new Connector();
        connector.getConnect();

            String sql = "SELECT login FROM tickets.users "
                    + "WHERE login ='" + uLogin+ "' "
                    + "AND password ='" + uPassword+ "' ";



            }





    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        checkUser(request, response);
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
    }
}