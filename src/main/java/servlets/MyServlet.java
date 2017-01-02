package servlets;

/**
 * Work with MVC`s
 * Add controller
 */
import models.User;

/**
 * Work with MVC`s
 * Add controller
 */
import services.UserStorage;

/**
 * Add servlet`s dependencies to programm`s logic
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add logger to programm`s logic
 */
import static org.slf4j.LoggerFactory.getLogger;
import org.slf4j.Logger;

/**
 * Add another dependencies;
 */
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**.
 * Servlet for use programm
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class MyServlet extends HttpServlet  {

    private static final Logger Log = getLogger(MyServlet.class);

    /**
     * Add storage of users
     */
    private final UserStorage storage = UserStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTime(
                        new SimpleDateFormat("dd-MM-yyyy")
                        .parse(request.getParameter("create"))
                );
            this.storage.add(
                    new User(
                            request.getParameter("name"),
                            request.getParameter("login"),
                            cal
                    )
            );
            } catch (ParseException e) {
                Log.error("",e);
            }
        response.sendRedirect("/index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

    }
}
