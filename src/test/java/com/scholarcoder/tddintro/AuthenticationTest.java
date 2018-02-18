package com.scholarcoder.tddintro;

import com.scholarcoder.tddintro.authentication.*;
import com.scholarcoder.tddintro.authentication.exception.AuthenticationFailureException;
import com.scholarcoder.tddintro.authentication.exception.UserNotFoundException;
import com.scholarcoder.tddintro.user.repository.InMemoryUserRepository;
import com.scholarcoder.tddintro.user.Session;
import com.scholarcoder.tddintro.user.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticationTest {

    @Test
    public void testUserLoginWithCorrectCredentials() throws Exception {

        // Given that this current user exists
        String username = "adrianvdh";
        String password = "hello123";
        UserRepository userRepository = new InMemoryUserRepository();
        AuthenticationService authenticationService = new AuthenticationService(userRepository);

        // When authenticating
        authenticationService.login(username, password);

        // The the current user session must be valid
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
        AuthenticationService authenticationService = new AuthenticationService(userRepository);

        //When authenticating
        authenticationService.login(username, password);
    }

    @Test(expected = AuthenticationFailureException.class)
    public void testUserLoginWhereUserPasswordIsIncorrect() throws Exception {

        // Given that this current user has the incorrect password
        String username = "adrianvdh";
        String password = "flowers2006";
        UserRepository userRepository = new InMemoryUserRepository();
        AuthenticationService authenticationService = new AuthenticationService(userRepository);

        // When authenticating
        authenticationService.login(username, password);
    }

}
