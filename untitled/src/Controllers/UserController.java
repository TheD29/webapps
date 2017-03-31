package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dima on 29.03.2017.
 */
@WebServlet(name = "UserController")
public class UserController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String uName = request.getParameter("username");
        PrintWriter pw = response.getWriter();

        if (uName.equals("Dima")) {
            request.setAttribute("username", uName);
            //response.sendRedirect("/pages/main.jsp");
            request.getRequestDispatcher("/pages/main.jsp").forward(request, response);

        } else if (uName != null | uName != "Dima")
           pw.print("asdasdasdasфвіфвіфвіф");
    }


}



