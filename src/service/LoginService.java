package service;

import dao.UserDAO;
import model.User;

public class LoginService {

    private final UserDAO userDAO;

    public LoginService() {

        userDAO = new UserDAO();

    }

    public boolean register(String username,
                            String password) {

        User user = new User();

        user.setUsername(username);

        user.setPassword(password);

        return userDAO.register(user);

    }

    public User login(String username,
                      String password) {

        return userDAO.login(username,
                password);

    }

}