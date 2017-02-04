package servlets;

import models.User;
import services.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**.
 * Class describe a logic of edit user`s parameters
 * @author k0r0tk0ff
 * @author peterarsentev
 * @since 04.02.2017
 * @version 1.1
 */

public class UserEdit extends HttpServlet {

    private final UserStorage storage = UserStorage.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * Bind parameter "hiddenId" for use in edit user operation.
         */
        request.setAttribute("hiddenId", request.getParameter("id"));

        /**
         * Bind parameter "users" for access to database with users
         */
        request.setAttribute("users", storage.getAll());

        /**
         * After binding - forward to jsp page with web-interface for enter
         * new data of user.
         */
        request.getRequestDispatcher("/WEB-INF/views/users/edit.jsp").forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        /**. After forward to jsp page with web-interface and enter
         * interact new data of user, write that data and do main logic of servlet.
         */


        /**.
         * Delete user whith parameter "id" determinate in request
         */
        storage.getInstance().delUserById(Integer.valueOf(request.getParameter("id")));

        /**.
         * Create new user with new parameter? but old parameter "id"
         */
        User editedUser = new User();
        editedUser.setEmail(request.getParameter("newEmail"));
        editedUser.setLogin(request.getParameter("newLogin"));
        editedUser.setPassword(request.getParameter("newPassword"));

        /**.
         * Convert to Integer requested parameter "id"
         * Remember! Servlets work with only text-type parameters!
         */
        editedUser.setId(Integer.valueOf(request.getParameter("id")));

        /**.
         * Save new user in our database.
         */
        storage.getInstance().add(editedUser);

        response.sendRedirect(String.format("%s/",request.getContextPath()));

    }
}
