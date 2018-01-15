package com.scholarcoder.tddintro;

public class UserService {
    public Session session;

    public void login(String username, String password) {
        User foundUser = new User();
        foundUser.username = username;
        foundUser.password = password;

        if(foundUser.username.equals(username) && foundUser.password.equals(password)) {
            session = new Session();
            session.user = new User();
            session.user.username = foundUser.username;
            session.user.password = foundUser.password;
        }
    }
}
