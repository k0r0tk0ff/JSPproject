package services;

import models.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;


import static org.slf4j.LoggerFactory.getLogger;

/**.
 * Class for save users.
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class UserStorage {

     private static final org.slf4j.Logger Log = getLogger(UserStorage.class);

     private final CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<User>();

     public AtomicInteger id = new AtomicInteger(0);
    /**.
     * Use singletone conception -
     * https://habrahabr.ru/post/27108/
     */
    public UserStorage() {
        User root = new User();
        root.setEmail("rootmail@mail.ru");
        root.setId(0);
        root.setLogin("root");
        root.setPassword("asdf");
        this.users.add(root);
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

    public User getUserById(int id) {
        User findUser = null;
        for (User user: this.users) {
            if (user.getId() == id) findUser = user;
        }
        return findUser;
    }

    public List<User> getAll() {
        return this.users;
    }

    public void update(User user) {
        this.users.remove(user);
        this.users.add(user);
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

}
