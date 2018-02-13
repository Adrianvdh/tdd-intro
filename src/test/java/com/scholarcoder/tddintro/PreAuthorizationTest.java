package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class PreAuthorizationTest {

    @Test
    public void publishPost() throws Exception {
        PostService postService = new PostService();
        Post newPost = new Post("Hello world!", "This is my first post!", "adrianvdh");

        postService.publish(newPost);

        Post post = postService.findLatestPublishedPost();
        Assert.assertTrue(post.getReleaseStatus() == ReleaseStatus.PUBLISHED);
    }
}
