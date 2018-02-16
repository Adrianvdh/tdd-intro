package com.scholarcoder.tddintro;

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
