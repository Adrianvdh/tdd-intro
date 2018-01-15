package com.scholarcoder.tddintro;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public Session session;

    List<User> users = new ArrayList<>();
    {
        User user = new User();
        user.username = "adrianvdh";
        user.password = "hello123";
        users.add(user);
    }

    public void login(String username, String password) {
        User foundUser = users.get(0);

        if(foundUser.username.equals(username) && foundUser.password.equals(password)) {
            session = new Session();
            session.user = new User();
            session.user.username = foundUser.username;
            session.user.password = foundUser.password;
        }
    }
}
