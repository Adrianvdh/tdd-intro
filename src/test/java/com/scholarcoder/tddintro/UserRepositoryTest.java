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
}
