package service;

import models.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Test connect to db
 *
 */
public class JDBCconnectorTest {
    @Test
    public void CheckForReadPropertiesFile() throws Exception {

        /**.
         *  Test load settings from file
         *  (with private constructor)
         */
        Settings settings = Settings.getInstance();
        assertThat(settings.getValue("jdbc.username"), is("postgres"));
    }

    @Test
    public void JDBCconnectorTestToDB() throws Exception {

         /**.
         *  Check for install JDBC driver
         */
        System.out.println("--- PostgreSQL JDBC Connection Testing ----");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Install PostgreSQL JDBC Driver!");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        /**.
         *  Test connection
         */
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/petclinic",
                    "postgres",
                    "zxcvbnm");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println(" Connect successful !");
        } else {
            System.out.println(" Connection Failed!");
        }
    }

    @Test
    public void ConnectToDbAndGetSimpleSqlQuery () throws SQLException {

        List<User> userList = new ArrayList<>();

        Settings settings = Settings.getInstance();

        final Connection testConnectionOne = DriverManager.getConnection(
                settings.getValue("jdbc.url"),
                settings.getValue("jdbc.username"),
                settings.getValue("jdbc.password"));

        final Statement statement = testConnectionOne.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients") ;

        System.out.print("id           name");


        while (resultSet.next()) {
            System.out.print("\n" + resultSet.getInt("id"));
            System.out.print("            " + resultSet.getString("name"));

        }
        testConnectionOne.close();
    }

    @Test
    public void ConnectToDbUsePreparedStatement () throws SQLException {

        // Use https://habrahabr.ru/sandbox/41444/

        Settings settings = Settings.getInstance();

        final Connection testConnectionOne = DriverManager.getConnection(
                settings.getValue("jdbc.url"),
                settings.getValue("jdbc.username"),
                settings.getValue("jdbc.password"));

        final Statement statement = testConnectionOne.createStatement();

        PreparedStatement preparedStatement = null;

        String prepareSqlQuery = "SELECT * FROM clients";

        //preparedStatement = testConnectionOne.prepareStatement("SELECT * FROM clients");
        preparedStatement = testConnectionOne.prepareStatement(prepareSqlQuery);

        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.print("id           name");

        /**.
         * For correct queries need check type of requested variables -
         * id need type int, name need type String.
         * See SQL code, where table "clients" was created.
         */
        while (resultSet.next()) {
            System.out.print("\n" + resultSet.getInt("id"));
            System.out.print("            " + resultSet.getString("name"));

        }
        testConnectionOne.close();
    }
}