package com.scholarcoder.tddintro;

public class PostService {
    public PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void publish(Post post) {
        post.releaseStatus = ReleaseStatus.PUBLISHED;
        postRepository.save(post);
    }
}
