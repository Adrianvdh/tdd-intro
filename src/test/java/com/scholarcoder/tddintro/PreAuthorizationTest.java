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
        PostService postService = new PostService(postRepository);
        UserAuthorization userAuthorization = new UserAuthorization();
        SecuredPostServiceProxy securedPostServiceProxy = new SecuredPostServiceProxy(postService, userAuthorization);
        Post draftPost = new Post("My first post", "Hello world", "adrianvdh");

        securedPostServiceProxy.publish(draftPost);

        Post publishedPost = postService.getMostRecentPublishedPost();
        Assert.assertTrue(publishedPost.releaseStatus == ReleaseStatus.PUBLISHED);
    }
}
