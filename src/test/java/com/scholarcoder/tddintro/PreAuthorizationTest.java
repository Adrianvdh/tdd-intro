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

    @Test(expected = AuthenticationRequiredException.class)
    public void testAuthenticationRequired() throws Exception {

        UserAuthorization userAuthorization = new UserAuthorization();

        userAuthorization.requiresAuthentication();
    }

    @Test(expected = AuthorizationFailedException.class)
    public void testUserIsOwnerAuthorization() throws Exception {

        AuthenticationService authenticationService = new AuthenticationService(new InMemoryUserRepository());
        authenticationService.login("adrianvdh", "hello123");
        UserAuthorization userAuthorization = new UserAuthorization();
        String ownerName = "john69";

        userAuthorization.requiresOwner(ownerName);
    }

    @Test
    public void publishPostThatRequiresAuthorization() throws Exception {
        AuthenticationService authenticationService = new AuthenticationService(new InMemoryUserRepository());
        authenticationService.login("adrianvdh", "hello123");

        PostRepository postRepository = new InMemoryPostRepository();
        UserAuthorization userAuthorization = new UserAuthorization();
        PostService postService = new PostService(postRepository, userAuthorization);
        Post draftPost = new Post("My first post", "Hello world", "adrianvdh");

        postService.publish(draftPost);

        Post publishedPost = postRepository.findMostLastPublishedPost();
        Assert.assertTrue(publishedPost.releaseStatus == ReleaseStatus.PUBLISHED);
    }
}
