package servlets;

import models.Pet;
import models.User;
import services.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 2/6/17.
 */


public class AddPet extends HttpServlet {

	private UserStorage storage = UserStorage.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		User user = storage.getUserById(request.getParameter("id"));
		Pet pet = new Pet();
		pet.setNick(request.getParameter("nick"));
		pet.setOwnId(Integer.valueOf(request.getParameter("id")));
		pet.setPetId(user.petId.incrementAndGet());
		pet.setType(request.getParameter("type"));

		user.addPet(pet);

		response.sendRedirect(String.format("%s/",request.getContextPath()));
		//response.sendRedirect(String.format("%s/WEB-INF/views/users/showUserPets.jsp",request.getContextPath()));

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * Bind parameter "ownId" for use in edit user operation.
		 */
		request.setAttribute("ownId", request.getParameter("id"));

		/**
		 * Bind parameter "users" for access to database with users
		 */
		request.setAttribute("users", storage.getAll());

		/**
		 * After binding - forward to jsp page with web-interface for enter
		 * data of pet.
		 */
		request.getRequestDispatcher("/WEB-INF/views/users/addPet.jsp").forward(request, response);
	}
}
