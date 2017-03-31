package Administrator.Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Dima on 23.03.2017.
 */
public interface ServletModel {
    public static final String toPage = "/main.jsp";

    public void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
