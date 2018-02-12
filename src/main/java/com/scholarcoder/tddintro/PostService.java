package com.scholarcoder.tddintro;

public class PostService {
    public Post post;

    public void publish(Post post) {
        post.published = true;
        this.post = post;
    }
}
