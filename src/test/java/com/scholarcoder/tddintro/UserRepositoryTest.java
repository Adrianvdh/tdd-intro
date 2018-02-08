package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class UserRepositoryTest {

    @Test
    public void testFindByUsername_UserIsFound() {
        String username = "adrianvdh";
        UserRepository userRepository = new InMemoryUserRepository();

        User user = userRepository.findByUsername(username);

        Assert.assertEquals("adrianvdh", user.username);
    }

    @Test
    public void testFindByUsername_UsernameNotFound() {
        String username = "john69";
        UserRepository userRepository = new InMemoryUserRepository();

        User user = userRepository.findByUsername(username);

        Assert.assertNull(user);
    }
}
