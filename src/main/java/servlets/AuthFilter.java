package servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author parsentev
 * @since 11.07.2016
 */

public class AuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

		/**.
        * Use HttpServlet "shell"
        */
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		/**.
		 * Initialize session attributes
		 */
		HttpSession session = req.getSession(true);
        Object user = req.getAttribute("user");

		if (req.getRequestURI().contains("/login.do")) {
			chain.doFilter(request, response);
		} else if (session == null || user == null) {
			resp.sendRedirect();
		}

	}

	public void init(FilterConfig config) throws ServletException {

	}

	public void destroy() {
	}
}
