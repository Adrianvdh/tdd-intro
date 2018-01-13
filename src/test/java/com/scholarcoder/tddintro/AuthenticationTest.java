package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class AuthenticationTest {

    @Test
    public void userLoginWithCorrectCredentials() throws Exception {

        // Given that this user exists
        String username = "adrianvdh";
        String password = "hello123";
        UserService userService = new UserService();

        // When authenticating
        userService.login(username, password);

        // Then the session must be valid
        Session userSession = userService.session;
        Assert.assertEquals("adrianvdh", userSession.user.username);
        Assert.assertEquals("hello123", userSession.user.password);

    }
}
