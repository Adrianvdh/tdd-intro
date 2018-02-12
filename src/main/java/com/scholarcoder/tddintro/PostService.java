package com.scholarcoder.tddintro;

public class PostService {

    private PostRepository postRepository;
    private UserAuthorization userAuthorization;

    public PostService(PostRepository postRepository, UserAuthorization userAuthorization) {
        this.postRepository = postRepository;
        this.userAuthorization = userAuthorization;
    }

    public void publish(Post post) {
        userAuthorization.requiresOwner(post.authorUserName);

        post.releaseStatus = ReleaseStatus.PUBLISHED;
        postRepository.save(post);
    }
}
