package servlets;

import models.User;
import services.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**.
 * Servlet for del user`s pet
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */

public class DelPet extends HttpServlet {

	private UserStorage storage = UserStorage.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = storage.getUserById(request.getParameter("id"));
		int intPetId = Integer.valueOf(request.getParameter("petId"));

		user.delPet(user.getPetById(intPetId));

		/**
		 * Work with http session
		 */

		HttpSession session = request.getSession(true);

		User sessionUser = (User) session.getAttribute("user");



		//response.sendRedirect(String.format("%s/login.do", request.getContextPath()));


		//response.sendRedirect("login.do");

		response.sendRedirect(String.format("/users/showpets.do?id=%s",
				request.getParameter("id")));

		//request.getRequestDispatcher(String.format("%s/users/showpets.do?id=%s",
		//		request.getContextPath(), request.getParameter("id"))).forward(request, response);

		//request.getContextPath(), String.valueOf(request.getParameter("id"))));

/*		if (sessionUser.getRole().equals("ROLE_ADMIN")) {
				response.sendRedirect(String.format("%s/users/UsersView.do", request.getContextPath()));}
		else {response.sendRedirect(String.format("%s/users/showpets.do?id=%s",
						request.getContextPath(), String.valueOf(sessionUser.getId())));}*/


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = storage.getUserById(request.getParameter("id"));
		int intPetId = Integer.valueOf(request.getParameter("petId"));

		user.delPet(user.getPetById(intPetId));

		/**
		 * After binding - forward to jsp page with web-interface for enter
		 * data of pet.
		 */
		//request.getRequestDispatcher("/WEB-INF/views/users/showUserPets.jsp?id=${userId}").forward(request, response);
		//request.getRequestDispatcher("/users/showpets.do?id=${request.getParameter("id")}").forward(request, response);
		//request.getRequestDispatcher("/").forward(request, response);
		//request.getRequestDispatcher("/WEB-INF/views/users/showUserPets.jsp").forward(request, response);
		//response.sendRedirect(String.format("%s/",request.getContextPath()));
		//response.sendRedirect(String.format("%s/WEB-INF/views/users/showUserPets.jsp?id=${request.getParameter(\"id\")}",request.getContextPath()));

		request.getRequestDispatcher("/login.do").forward(request, response);



	}
}
