package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class AuthenticationTest {

    @Test
    public void userLoginWithCorrectCredentials() throws Exception {

        // Given that this user exists
        String username = "adrianvdh";
        String password = "hello123";
        AuthorisationContext authorisationContext = new AuthorisationContext();

        // When authenticating
        authorisationContext.authenticate(username, password);

        // Then the session must be valid
        Session userSession = Session.getCurrentSession();
        Assert.assertEquals("adrianvdh", userSession.getAuthenticatedUser().username);
        Assert.assertEquals("hello123", userSession.getAuthenticatedUser().password);

    }
}
