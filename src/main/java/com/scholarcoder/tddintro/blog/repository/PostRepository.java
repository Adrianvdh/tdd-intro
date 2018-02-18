package com.scholarcoder.tddintro.blog.repository;

import com.scholarcoder.tddintro.blog.model.Post;

public interface PostRepository {
    void save(Post post);

    Post findLatestPublishedPost();
}
