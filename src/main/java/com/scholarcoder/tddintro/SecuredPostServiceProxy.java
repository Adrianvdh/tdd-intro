package com.scholarcoder.tddintro;

public class SecuredPostServiceProxy {

    private PostService postService;
    private UserAuthorization userAuthorization;

    public SecuredPostServiceProxy(PostService postService, UserAuthorization userAuthorization) {
        this.postService = postService;
        this.userAuthorization = userAuthorization;
    }

    public void publish(Post post) {
        userAuthorization.requiresOwner(post.authorUserName);

        post.releaseStatus = ReleaseStatus.PUBLISHED;

        postService.save(post);
    }
}
