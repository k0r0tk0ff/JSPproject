package services;

import models.Pet;
import models.User;

import java.util.List;
import java.util.Optional;
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
        root.setRole("ROLE_ADMIN");
        root.setPassword("asdf");
        root.addPet(new Pet(0, root.petId.incrementAndGet(), "dog", "Rex"));
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

    public User getUserById(String id) {
        User findUser = null;
        for (User user: this.users) {
            if (user.getId() == Integer.valueOf(id)) findUser = user;
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

    /**.
     * User findByCridentional(String username, String password) use in login page
     *
     * @param username - entered username
     * @param password - entered password
     */

    public Optional<User>  findByCredentional(String username, String password) {

        Optional<User> userForReturn = Optional.empty();

        for (User findUser: this.users) {
            if(findUser.getLogin().equals(username)) {
                if (findUser.getPassword().equals(password)) userForReturn = Optional.of(findUser);
            }
        }
        return userForReturn;
    }

}
