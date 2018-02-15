package com.scholarcoder.tddintro;

public class PostService {
    public PostRepository postRepository;

    private UserAuthorization userAuthorization;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.userAuthorization = new UserAuthorization();
    }

    public void publish(Post post) {
        userAuthorization.userIsOwner(post);

        post.releaseStatus = ReleaseStatus.PUBLISHED;
        postRepository.save(post);
    }
}
