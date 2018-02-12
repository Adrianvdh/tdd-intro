package com.scholarcoder.tddintro;

import org.junit.Assert;
import org.junit.Test;

public class PreAuthorizationTest {

    @Test
    public void publishPost() throws Exception {
        Post newPost = new Post("Hello world!", "This is my first post!", "adrianvdh");
        PostService postService = new PostService();
        postService.publish(newPost);
        Post post = postService.post;
        Assert.assertTrue(post.published);
    }
}
