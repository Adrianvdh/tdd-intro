package com.scholarcoder.tddintro.blog;

import com.scholarcoder.tddintro.blog.model.Post;
import com.scholarcoder.tddintro.blog.model.ReleaseStatus;
import com.scholarcoder.tddintro.authorization.UserAuthorization;
import com.scholarcoder.tddintro.blog.repository.PostRepository;

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
