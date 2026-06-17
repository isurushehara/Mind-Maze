package dao;

import database.DBConnection;
import model.User;
import util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // Register
    public boolean register(User user) {

        String sql =
                "INSERT INTO users(username,password) VALUES(?,?)";

        try (
                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    user.getUsername()
            );

            statement.setString(
                    2,
                    PasswordUtil.hashPassword(
                            user.getPassword())
            );

            return statement.executeUpdate() > 0;

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Login
    public User login(String username,
                      String password) {

        String sql =
                "SELECT * FROM users WHERE username=?";

        try (

                Connection connection =
                        DBConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)

        ) {

            statement.setString(1, username);

            ResultSet resultSet =
                    statement.executeQuery();

            if (resultSet.next()) {

                String dbPassword =
                        resultSet.getString("password");

                String inputHash =
                        PasswordUtil.hashPassword(password);

                if (dbPassword.equals(inputHash)) {

                    User user = new User();

                    user.setId(
                            resultSet.getInt("id"));

                    user.setUsername(
                            resultSet.getString("username"));

                    return user;

                }

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }
}