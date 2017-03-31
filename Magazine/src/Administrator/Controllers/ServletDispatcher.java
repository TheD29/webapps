package Administrator.Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by Dima on 22.03.2017.
 */
public class ServletDispatcher extends HttpServlet {

    public void forward(String toPage, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(toPage);//Вказуємо на яку сторінку перейти
        requestDispatcher.forward(request, response);
    }
}
