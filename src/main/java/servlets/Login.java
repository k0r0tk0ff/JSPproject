package servlets;

import models.User;
import org.slf4j.Logger;
import services.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 11.07.2016
 */
public class Login extends HttpServlet {
    private static final Logger log = getLogger(Login.class);
    private final UserStorage userStorage = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usernameFromRequest = req.getParameter("username");

        /**
         * Bind parameter "users" for access to database with users
         */
        req.setAttribute("users", userStorage.getAll());

        Optional<User> result = this.userStorage.findByCredentional(req.getParameter("username"),
                req.getParameter("password"));
        if (result.isPresent()) {
            User user = result.get();
            req.getSession().setAttribute("user", user);
            if ("ROLE_ADMIN".equals(user.getRole())) {
                 resp.sendRedirect(String.format("%s/users/UsersView.do", req.getContextPath()));
            } else {
                 req.setAttribute("ownId", String.valueOf(user.getId()));
                 resp.sendRedirect(String.format("%s/users/showpets.do?id=%s",
                     req.getContextPath(), String.valueOf(user.getId())));
            }
        } else {
            this.doGet(req, resp);
        }
    }
}