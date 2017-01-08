package services;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**.
 * Class for save users.
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class UserStorage {

    //private final List<User> users = new ArrayList<User>();
    private final CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<User>();

    /**.
     * Use singletone conception -
     * https://habrahabr.ru/post/27108/
     */
    private static final UserStorage INSTANCE = new UserStorage();

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
