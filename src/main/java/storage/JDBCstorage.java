package storage;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Import local packages.
 */
import models.User;
import service.Settings;

/**
 * Storage, where data is saved in DB
 */

public class JDBCstorage implements Storage {
        
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Settings settings = null;

    public JDBCstorage() throws SQLException {
        Settings settings = Settings.getInstance();

        final Connection testConnectionOne = DriverManager.getConnection(
        settings.getValue("jdbc.url"),
        settings.getValue("jdbc.username"),
        settings.getValue("jdbc.password"));
        final Statement statement = connection.createStatement();
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
    public List<User> getAll() throws SQLException {
        final List <User> users = new ArrayList<>();

        final String prepareSqlQuery = "SELECT * FROM clients";

        preparedStatement = connection.prepareStatement(prepareSqlQuery);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            users.add(new User
               (
                    resultSet.getInt("id"),
                    resultSet.getString("name")
               )
            );
        }

        connection.close();

        return users;
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
