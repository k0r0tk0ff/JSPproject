package storage;

import models.User;

import java.util.List;
import java.util.Optional;

/**
 * Selector of storage -
 * data save in memory or in DB
 */
public class WorkStorage implements Storage {

    /**
     * Chose work storage
     *
     */



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
