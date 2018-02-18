package com.scholarcoder.tddintro;

import com.scholarcoder.tddintro.blog.repository.InMemoryPostRepository;
import com.scholarcoder.tddintro.blog.model.Post;
import com.scholarcoder.tddintro.blog.repository.PostRepository;
import com.scholarcoder.tddintro.blog.model.ReleaseStatus;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class PostRepositoryTest {

    @Test
    public void testSaveAndReturnLatestPublishedPost() throws Exception {
        PostRepository postRepository = new InMemoryPostRepository();
        Post newPost = new Post("Hello world!", "This is my first post!", "adrianvdh");
        newPost.releaseStatus = ReleaseStatus.PUBLISHED;

        postRepository.save(newPost);

        Post savedPost = postRepository.findLatestPublishedPost();
        Assert.assertThat(savedPost, Matchers.is(newPost));
    }
}
