package servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author parsentev
 * @since 11.07.2016
 */

public class AuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletRequest resp = (HttpServletRequest) response;
		HttpSession session = req.getSession(true);
        Object user = req.getAttribute("user");

		if (req.getRequestURI().contains("/login.do")) {
			chain.doFilter(request, response);
		} else if (session == null || user == null) {

		}

	}

	public void init(FilterConfig config) throws ServletException {

	}

	public void destroy() {
	}
}
