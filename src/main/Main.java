package main;

import dao.UserDAO;
import database.DBConnection;
import model.User;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            UserDAO dao = new UserDAO();

            User user = new User();

            user.setUsername("john");
            user.setPassword("123456");

            boolean success = dao.register(user);

            System.out.println(success);


            connection.close();



        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}