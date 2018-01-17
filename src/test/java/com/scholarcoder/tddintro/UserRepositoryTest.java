package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class UserRepositoryTest {

    @Test
    public void testFindByUsername() {
        String username = "adrianvdh";
        UserRepository userRepository = new InMemoryUserRepository();

        User user = userRepository.findByUsername(username);

        Assert.assertEquals("adrianvdh", user.username);
    }

    @Test(expected = UserNotFoundException.class)
    public void testFindByUsername_UsernameNotFound() {
        String username = "kentb";
        UserRepository userRepository = new InMemoryUserRepository();

        //when
        User user = userRepository.findByUsername(username);
    }
}
