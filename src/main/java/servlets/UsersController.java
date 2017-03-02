package servlets;

/**.
 * Work with MVC`s
 * Add controller
 */
import models.User;

/**.
 * Work with MVC`s
 * Add controller
 */
import services.UserStorage;

/**.
 * Add servlet`s dependencies to programm`s logic
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add another dependencies;
 */
import java.io.IOException;

/**.
 * Servlet for use programm
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class UsersController extends HttpServlet  {

     /**
     * Add storage of users
     */
    private final UserStorage storage = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /**.
         * Add binding (alias) - in java "attribute"
         * for use short path in calls.
         */
        request.setAttribute("users", storage.getAll());

        /**.
         * Add dispatcher whose routing our requests.
         * All request forward to page /WEB-INF/views/UsersView.jsp .
         */
        request.getRequestDispatcher("/WEB-INF/views/users/UsersView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        User newUser = new User();
        newUser.setEmail(request.getParameter("email"));
        newUser.setLogin(request.getParameter("login"));
        newUser.setId(storage.id.incrementAndGet());
        newUser.setPassword(request.getParameter("password"));
        newUser.setRole(request.getParameter("role"));
        storage.getInstance().add(newUser);

        //response.sendRedirect(String.format("%s/",request.getContextPath()));
        response.sendRedirect(String.format("%s/users/UsersView.do",request.getContextPath()));
    }
}
