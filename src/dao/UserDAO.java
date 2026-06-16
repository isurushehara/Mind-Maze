package dao;

import database.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {

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
                    user.getPassword()
            );

            return statement.executeUpdate() > 0;

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}