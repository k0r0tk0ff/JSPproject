package storage;

import models.User;
import org.apache.maven.settings.Settings;

import java.util.List;
import java.util.Optional;

/**
 * Storage, where data is saved in DB
 */

public class JDBCstorage implements Storage {

    public JDBCstorage {
        final Settings settings = settings.getInstanse();
    }


    @Override
    public void add(User user) {

    }

    @Override
    public void delUserById(int id) {

    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User getUserByLogin(String loginForFind) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public Optional<User> findByCredentional(String username, String password) {
        return null;
    }
}
