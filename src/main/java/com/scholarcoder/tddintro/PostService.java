package com.scholarcoder.tddintro;

public class PostService {
    public Post post;

    public void publish(Post post) {
        post.releaseStatus = ReleaseStatus.PUBLISHED;
        this.post = post;
    }

    public Post findLatestPublishedPost() {
        return post;
    }
}
