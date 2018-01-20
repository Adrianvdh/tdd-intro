package com.scholarcoder.tddintro;

public class PostService {

    private Post post;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.userService = userService;
    }

    public void publish(Post postToPublish) {
        this.userService.preAuthorize();
        this.post = postToPublish;
        this.post.published = true;
    }

    public Post getMostRecentPublishedPost() {
        return this.post;
    }
}
