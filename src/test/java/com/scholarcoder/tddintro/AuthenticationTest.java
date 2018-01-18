package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class AuthenticationTest {

    @Test
    public void userLoginWithCorrectCredentials() throws Exception {

        // Given that this user exists
        String username = "adrianvdh";
        String password = "hello123";
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        // When authenticating
        userService.login(username, password);

        // The the user session must be valid
        Session userSession = Session.getCurrentSession();
        Assert.assertEquals("adrianvdh", userSession.user.username);
        Assert.assertEquals("hello123", userSession.user.password);
    }

    @Test(expected = AuthenticationFailureException.class)
    public void userLoginWhereUserIsNotFound() throws Exception {

        // Given that this user don't exist
        String username = "adrianvdh";
        String password = "flowers2006";
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        // When authenticating
        userService.login(username, password);
    }

}
