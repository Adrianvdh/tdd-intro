package com.scholarcoder.tddintro;

import com.scholarcoder.tddintro.authorization.exception.AuthenticationRequiredException;
import com.scholarcoder.tddintro.authorization.exception.AuthorizationDeniedAccessException;
import com.scholarcoder.tddintro.authorization.model.OwnerAwareEntity;
import com.scholarcoder.tddintro.blog.*;
import com.scholarcoder.tddintro.blog.model.Post;
import com.scholarcoder.tddintro.blog.model.ReleaseStatus;
import com.scholarcoder.tddintro.blog.repository.InMemoryPostRepository;
import com.scholarcoder.tddintro.blog.repository.PostRepository;
import com.scholarcoder.tddintro.user.*;
import com.scholarcoder.tddintro.authentication.*;
import com.scholarcoder.tddintro.authorization.*;
import com.scholarcoder.tddintro.user.repository.InMemoryUserRepository;
import com.scholarcoder.tddintro.user.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PreAuthorizationTest {

    @Before
    public void setUp() throws Exception {
        Session.getCurrentSession().setAuthenticatedUser(null);
    }

    @Test
    public void publishPost() throws Exception {
        UserRepository userRepository = new InMemoryUserRepository();
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        authenticationService.login("adrianvdh", "hello123");

        PostRepository postRepository = new InMemoryPostRepository();
        PostService postService = new PostService(postRepository);
        Post newPost = new Post("Hello world!", "This is my first post!", "adrianvdh");

        postService.publish(newPost);

        Post post = postRepository.findLatestPublishedPost();
        Assert.assertTrue(post.getReleaseStatus().equals(ReleaseStatus.PUBLISHED));
    }

    @Test(expected = AuthorizationDeniedAccessException.class)
    public void publishPost_userIsNotOwnerFailure() throws Exception {
        UserRepository userRepository = new InMemoryUserRepository();
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        authenticationService.login("adrianvdh", "hello123");

        PostRepository postRepository = new InMemoryPostRepository();
        PostService postService = new PostService(postRepository);
        Post newPost = new Post("John's post", "Hey, howzit!", "john69");

        postService.publish(newPost);
    }

    @Test(expected = AuthenticationRequiredException.class)
    public void methodRequiresAuthentication() throws Exception {
        UserAuthorization userAuthorization = new UserAuthorization();

        userAuthorization.requiresAuthentication();
    }

    @Test(expected = AuthorizationDeniedAccessException.class)
    public void userIsOwnerAuthorization() throws Exception {
        UserRepository userRepository = new InMemoryUserRepository();
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        authenticationService.login("adrianvdh", "hello123");

        UserAuthorization userAuthorization = new UserAuthorization();
        String ownerUsername = "john69";

        userAuthorization.userIsOwner(ownerUsername);
    }

    @Test(expected = AuthorizationDeniedAccessException.class)
    public void userIsOwnerAuthorization_usingOwnerAwareEntity() throws Exception {
        UserRepository userRepository = new InMemoryUserRepository();
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        authenticationService.login("adrianvdh", "hello123");

        UserAuthorization userAuthorization = new UserAuthorization();
        OwnerAwareEntity ownerAwareEntityPost = new Post("John's post", "Hey, howzit!", "john69");

        userAuthorization.userIsOwner(ownerAwareEntityPost);
    }
}
