package service;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Test connect to db
 *
 */
public class JDBCconnectorTest {
    @Test
    public void getInstance() throws Exception {
    }

    @Test
    public void getValue() throws Exception {
    }

    @Test
    public void JDBCconnectorTestToDB() throws Exception {

        /**.
         *  Test load settings from file
         *  (with private constructor)
         */
        Settings settings = Settings.getInstance();
        assertThat(settings.getValue("jdbc.username"), is("postgres"));


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

}