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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("hiddenId", request.getParameter("id"));

        request.setAttribute("users", storage.getAll());

        request.getRequestDispatcher("/WEB-INF/views/users/edit.jsp").forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        User editedUser = new User();
        editedUser.setEmail(request.getParameter("newEmail"));
        editedUser.setLogin(request.getParameter("newLogin"));
        editedUser.setPassword(request.getParameter("newPassword"));
        storage.getInstance().add(editedUser);

        response.sendRedirect(String.format("%s/",request.getContextPath()));

    }
}
