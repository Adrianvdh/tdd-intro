package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PreAuthorizationTest {

    @Before
    public void setUp() throws Exception {
        Session session = Session.getCurrentSession();
        session.setAuthenticatedUser(null);
    }

    @Test
    public void publishPostThatRequiresAuthorization() throws Exception {

        UserService userService = new UserService(new InMemoryUserRepository());
        PostRepository postRepository = new InMemoryPostRepository();
        PostService postService = new PostService(postRepository, userService);
        Post newPost = new Post("My first post", "Hello world");

        userService.login("adrianvdh", "hello123");
        postService.publish(newPost);

        Post publishedPost = postService.getMostRecentPublishedPost();
        Assert.assertTrue(publishedPost.published);
    }

    @Test(expected = AuthorizationRequiredException.class)
    public void testPreAuthorizeMethod() throws Exception {

        UserService userService = new UserService(new InMemoryUserRepository());

        userService.preAuthorize();
    }
}
