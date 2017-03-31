package Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Dima on 29.03.2017.
 */
public interface MainController {

    public void checkUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException;


}
