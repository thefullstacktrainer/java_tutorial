package org.example;
import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/consultation_platform";
        String user = "admin";
        String password = "password";

        try {
            // Register MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database consultation...");
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {

                String columnName = resultSet.getString("name");
                System.out.println(columnName);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
