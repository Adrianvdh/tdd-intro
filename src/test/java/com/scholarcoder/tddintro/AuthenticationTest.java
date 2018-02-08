package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {

    @Test
    public void testUserLoginWithCorrectCredentials() throws Exception {

        // Given that this current user exists
        String username = "adrianvdh";
        String password = "hello123";
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        // When authenticating
        userService.login(username, password);

        // The the currentUser session must be valid
        Session userSession = Session.getCurrentSession();
        Assert.assertEquals("adrianvdh", userSession.getAuthenticatedUser().username);
        Assert.assertEquals("hello123", userSession.getAuthenticatedUser().password);
    }

    @Test(expected = UserNotFoundException.class)
    public void testUserLoginWhereUserDoesNotExit() {

        // Given that this current user doesn't exist
        String username = "john69";
        String password = "hello123";
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        //When authenticating
        userService.login(username, password);
    }

    @Test(expected = AuthenticationFailureException.class)
    public void testUserLoginWhereUserPasswordIsIncorrect() throws Exception {

        // Given that this current user has the incorrect password
        String username = "adrianvdh";
        String password = "flowers2006";
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        // When authenticating
        userService.login(username, password);
    }

}
