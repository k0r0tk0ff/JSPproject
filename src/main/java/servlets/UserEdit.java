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

    private final UserStorage users = UserStorage.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        User user = UserStorage.getInstance().getUserById(request.getParameter("id"));

        user.setLogin(request.getParameter("newLogin"));
        user.setEmail(request.getParameter("newEmail"));
        user.setPassword(request.getParameter("newPassword"));

        response.sendRedirect(String.format("%s/",request.getContextPath()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", this.users.getUserById(request.getParameter("id")));
        request.getRequestDispatcher("/WEB-INF/views/users/edit.jsp").forward(request, response);
    }
}
