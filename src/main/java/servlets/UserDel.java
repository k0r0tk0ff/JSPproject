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

public class UserDel extends HttpServlet {

    private final UserStorage storage = UserStorage.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        /*storage.deleteUser(storage.getUserById(request.getParameter("id")));*/
        response.sendRedirect(String.format("%s/WEB-INF/views/UsersView.jsp",request.getContextPath()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        storage.deleteUser(storage.getUserById(request.getParameter("id")));
        request.setAttribute("users", storage.getAll());
        request.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(request, response);
    }
}
