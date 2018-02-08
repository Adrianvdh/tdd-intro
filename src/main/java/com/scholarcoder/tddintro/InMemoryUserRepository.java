package com.scholarcoder.tddintro;

import java.util.HashSet;
import java.util.Set;

public class InMemoryUserRepository implements UserRepository {
    Set<User> users = new HashSet<>();

    {
        User user = new User();
        user.username = "adrianvdh";
        user.password = "hello123";
        users.add(user);
    }

    @Override
    public User findByUsername(String username) {
        User foundUser = null;
        for (User userInCollection : users) {
            if (userInCollection.username.equals(username)) {
                foundUser = userInCollection;
                break;
            }
        }

        return foundUser;
    }
}
