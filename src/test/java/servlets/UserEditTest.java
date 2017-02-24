package servlets;

import models.User;
import org.junit.Test;
import org.mockito.Mockito;
import services.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.IsEqual.equalTo;

/**.
 * Test - edit the user properties.
 */

public class UserEditTest {

    private final UserStorage storage = UserStorage.getInstance();

    @Test
    public void whenExecutePostShouldEditUser() throws ServletException,IOException {

        /*
        * Create test etalon user for edit his properties, and after it compare in our test.
        */

        User userForEdit = new User (1);
        userForEdit.setEmail("main@mail");
        userForEdit.setLogin("root");
        userForEdit.setPassword("root");
        storage.getInstance().add(userForEdit);

        UserEdit userEdit = new UserEdit();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        /*.
         * Compare post`s values of response and java`s methods.
         */

       // when(request.getParameter("id")).thenReturn(String.valueOf(userForEdit.getId()));
       // when(request.getParameter("email")).thenReturn(userForEdit.getEmail());
        when(request.getParameter("neWemail")).thenReturn("newEmail@mail");

        doNothing().doThrow(new IllegalArgumentException()).when(request.getParameter("newEmail"));

        userEdit.doPost(request, response);

        //when(request.getParameter("login")).thenReturn("root");
        //when(request.getParameter("email")).thenReturn("main@mail");

        assertThat("newEmail@mail", equalTo(UserStorage.getInstance().getAll().get(0).getEmail()));
        assertThat(UserStorage.getInstance().getAll().iterator().next().getLogin(), is("root"));

        /*
         * Compare post`s values of response and save fields of created user.
         */
        //when(request.getParameter("login")).thenReturn("root");
        //when(request.getParameter("email")).thenReturn("main@mail");

    }
}