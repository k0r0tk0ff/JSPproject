package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**.
 * Simple code example.
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */

@WebServlet("/aaa")
public class MyServlet extends HttpServlet  {

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
