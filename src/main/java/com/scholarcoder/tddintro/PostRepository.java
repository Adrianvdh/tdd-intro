package com.scholarcoder.tddintro;

public interface PostRepository {
    void save(Post post);

    Post findLatestPublishedPost();
}
