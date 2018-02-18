package com.scholarcoder.tddintro.blog.repository;

import com.scholarcoder.tddintro.blog.model.Post;

public class InMemoryPostRepository implements PostRepository {

    private Post post;

    @Override
    public void save(Post post) {
        this.post = post;
    }

    @Override
    public Post findLatestPublishedPost() {
        return post;
    }
}
