package services;

import models.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


import static org.slf4j.LoggerFactory.getLogger;

/**.
 * Class for save users.
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class UserStorage {

     private static final org.slf4j.Logger Log = getLogger(UserStorage.class);

     private final CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<User>();

    /**.
     * Use singletone conception -
     * https://habrahabr.ru/post/27108/
     */
    public UserStorage() {
        this.users.add(
                new User("root",
                        "rootmail@mail",
                        "1",
                        "root"));
    }

    private static final UserStorage INSTANCE = new UserStorage();

    public static UserStorage getInstance() {
        return INSTANCE;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public void delUserById(int id) {
        for (User user: this.users) {
            if (user.getId() == id) this.users.remove(user);
        }
    }

    public List<User> getAll() {
        return this.users;
    }

}
