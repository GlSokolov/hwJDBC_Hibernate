package JDBC.connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection {

    public static void main(String[] args) throws SQLException {

        try (java.sql.Connection connection = getConnetion();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT  * FROM employee WHERE id = (?)") ) {

            statement.setInt(1, 1);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String gender = result.getString("gender");
                int age = result.getInt(5);

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(age);
            }

        }

    }

    public static java.sql.Connection getConnetion() throws SQLException {

        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String user = "postgres";
        final String password = "postgresSkyPro";

        return DriverManager.getConnection(url, user, password);
    }

}
