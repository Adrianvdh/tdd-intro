package com.scholarcoder.tddintro;

public class PostService {

    private Post post;

    public PostService(PostRepository postRepository) {
    }

    public void publish(Post postToPublish) {
        this.post = postToPublish;
        this.post.published = true;
    }

    public Post getMostRecentPublishedPost() {
        return this.post;
    }
}
