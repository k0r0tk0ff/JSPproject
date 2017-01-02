package services;

import models.User;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.List;





/**.
 * Class for save users.
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class UserStorage {

    private static final Logger Log = getLogger(UserStorage.class);
    private final List<User> users = new ArrayList<User>();

    /**.
     * Use singletone conception -
     * https://habrahabr.ru/post/27108/
     */
    private static final UserStorage INSTANCE = new UserStorage();


    private UserStorage() {
    }

    public static UserStorage getInstance() {
        return INSTANCE;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public List<User> getAll() {
        return this.users;
    }

}
