package models;

/**.
 * Class describe User`s abilities
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class User {
    private String login;
    private String email;

    public User(String inputLogin, String inputEmail) {
        this.email = inputEmail;
        this.login = inputLogin;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }
}