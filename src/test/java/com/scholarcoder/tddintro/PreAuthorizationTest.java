package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class PreAuthorizationTest {

    @Test
    public void publishPost() throws Exception {
        PostRepository postRepository = new InMemoryPostRepository();
        PostService postService = new PostService(postRepository);
        Post newPost = new Post("Hello world!", "This is my first post!", "adrianvdh");

        postService.publish(newPost);

        Post post = postRepository.findLatestPublishedPost();
        Assert.assertTrue(post.getReleaseStatus().equals(ReleaseStatus.PUBLISHED));
    }

    @Test(expected = AuthenticationRequiredException.class)
    public void methodRequiresAuthentication() throws Exception {
        UserAuthorization userAuthorization = new UserAuthorization();

        userAuthorization.requiresAuthentication();
    }

    @Test(expected = AuthorizationFailedException.class)
    public void userIsOwnerAuthorization() throws Exception {
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);
        userService.login("adrianvdh", "hello123");

        UserAuthorization userAuthorization = new UserAuthorization();
        String ownerUsername = "john69";

        userAuthorization.userIsOwner(ownerUsername);
    }
}
