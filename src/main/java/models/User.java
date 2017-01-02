package models;

import org.slf4j.Logger;
import java.util.Calendar;
import static org.slf4j.LoggerFactory.getLogger;

/**.
 * Class describe User`s abilities
 * @author Petr Arsentev
 * site - http://job4j.ru/
 */
public class User {
    private static final Logger Log = getLogger(User.class);
    private String login;
    private String email;
    private Calendar created;

    public User(String name, String login, Calendar created) {
        this.email = name;
        this.login = login;
        this.created = created;
    }

    public String getlogin() {
        return this.login;
    }

    public String getemail() {
        return this.email;
    }
}