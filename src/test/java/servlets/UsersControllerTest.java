package servlets;

import models.User;
import org.junit.Test;
import services.UserStorage;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.core.IsEqual.equalTo;

/**.
 * Test - fact create the user, if we
 * done post query.
 */
public class UsersControllerTest {

    @Test
    public void whenExecutePostShouldCreateUser() throws ServletException,IOException {

        /**
         * Create test etalon user for compare in our test
         */
        User user = new User ("testuser", "main@mail");
        UsersController usersController = new UsersController();
        UserStorage testStorage = new UserStorage();
        testStorage.add(user);

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        /**.
         * Compare post`s values of response and java`s methods.
         */
        when(request.getParameter("login")).thenReturn(user.getLogin());
        when(request.getParameter("e-mail")).thenReturn(user.getEmail());

        usersController.doPost(request, response);

        assertThat("testuser", equalTo(UserStorage.getInstance().getAll().iterator().next().getLogin()));
        assertThat(UserStorage.getInstance().getAll().iterator().next().getLogin(), is("testuser"));

        /**.
         * Compare post`s values of response and save fields of created user.
         */
        when(request.getParameter("login")).thenReturn("testuser");
        when(request.getParameter("email")).thenReturn("main@mail");

    }
}