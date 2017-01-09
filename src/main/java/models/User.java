package models;

/**.
 * Class describe User`s abilities
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class User {
    String login;
    String email;
    private String id;
    private String password;


    public User(String login, String email, String id, String password) {
        this.login = login;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}