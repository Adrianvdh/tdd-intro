package com.scholarcoder.tddintro;

public class PostService {

    private Post post;

    public PostService(PostRepository postRepository) {

    }

    public Post getMostRecentPublishedPost() {
        return this.post;
    }

    public void save(Post post) {
        this.post = post;
    }
}
