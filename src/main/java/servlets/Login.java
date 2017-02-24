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
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> result = this.userStorage.findByCridentional(req.getParameter("username"), req.getParameter("password"));
        if (result.isPresent()) {
            User user = result.get();
            req.getSession().setAttribute("user", user);
            if ("ROLE_ADMIN".equals(user.getRole().getName())) {
                resp.sendRedirect(String.format("%s/users.do", req.getContextPath()));
            } else {
                resp.sendRedirect(String.format("%s/client.do", req.getContextPath()));
            }
        } else {
            this.doGet(req, resp);
        }
    }
}