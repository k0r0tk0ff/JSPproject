package models;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static org.slf4j.LoggerFactory.getLogger;

/**.
 * Class describe User`s abilities
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class User {

    private static final org.slf4j.Logger Log = getLogger(User.class);

    private int id;

    public AtomicInteger petId = new AtomicInteger(0);

    private String login;
    private String email;
    private String password;

    private CopyOnWriteArrayList<Pet> pets = new CopyOnWriteArrayList<Pet>();

    public User() {
    }

    public User(int id) {
        this();
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String newLogin) {
        this.login = newLogin;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public CopyOnWriteArrayList<Pet> getUserPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
    }
}