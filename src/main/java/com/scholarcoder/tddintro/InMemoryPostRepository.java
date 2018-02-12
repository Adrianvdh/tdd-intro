package com.scholarcoder.tddintro;

public class InMemoryPostRepository implements PostRepository {

    private Post post;

    @Override
    public Post findMostLastPublishedPost() {
        return post;
    }

    @Override
    public void save(Post post) {
        this.post = post;
    }
}
