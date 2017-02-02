package servlets;

import models.User;
import services.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 2/1/2017.
 */

public class UserEdit extends HttpServlet {

    private final UserStorage storage = UserStorage.getInstance();

	private String bufferedID = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", storage.getAll());
        request.getRequestDispatcher("/WEB-INF/views/users/edit.jsp").forward(request, response);
	    bufferedID = request.getParameter("id");
	    UserStorage.getInstance().delUserById(request.getParameter("id"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

                UserStorage.getInstance().add(
                new User(request.getParameter("newLogin"),
                        request.getParameter("newEmail"),
                        bufferedID,
                        request.getParameter("newPassword")
                )
        );

/*        User newUser = UserStorage.getInstance().getUserById(bufferedID);

        newUser.setPassword(request.getParameter("newPassword"));
        newUser.setEmail(request.getParameter("newEmail"));
        newUser.setLogin(request.getParameter("newLogin"));*/

        response.sendRedirect(String.format("%s/",request.getContextPath()));

        /*response.sendRedirect(String.format("%s/WEB-INF/views/UsersView.jsp",request.getContextPath()));*/

    }


}
