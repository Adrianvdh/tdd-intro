package com.scholarcoder.tddintro;

public interface PostRepository {

    Post findMostLastPublishedPost();

    void save(Post post);
}
