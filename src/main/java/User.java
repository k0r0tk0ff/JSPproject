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
    private String name;
    private String login;
    private Calendar created;

    public User(String name, String login, Calendar created) {
        this.name = name;
        this.login = login;
        this.created = created;
    }
}