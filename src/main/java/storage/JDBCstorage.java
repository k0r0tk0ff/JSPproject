package storage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

public class JDBCstorage implements Storage throws ServletException,IOException {
        
    Connection connection = null;

    public JDBCstorage() {
        Settings settings = Settings.getInstance();
    }

    final Connection connection=DriverManager.getConnection(
        settings.getValue("jdbc.url"),
        settings.getValue("jdbc.username"),
        settings.getValue("jdbc.password"));

    final Statement statement=connection.createStatement();

    ResultSet resultSet=statement.executeQuery("SELECT * FROM clients");

    while(resultSet.next()){
        System.out.print("\n"+resultSet.getInt("id"));
        System.out.print("            "+resultSet.getString("name"));
        }
        connection.close();
    
    
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
