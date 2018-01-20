package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class PreAuthorizationTest {

    @Test
    public void publishPostThatRequiresAuthentication() throws Exception {

        PostRepository postRepository = new InMemoryPostRepository();
        PostService postService = new PostService(postRepository);
        Post newPost = new Post("My first post", "Hello world");

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
