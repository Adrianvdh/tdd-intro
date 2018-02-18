package com.scholarcoder.tddintro.blog.model;

import com.scholarcoder.tddintro.authorization.model.OwnerAwareEntity;

public class Post implements OwnerAwareEntity {

    public ReleaseStatus releaseStatus;
    private String authorName;

    public Post(String title, String body, String authorUsername) {
        authorName = authorUsername;
    }

    public ReleaseStatus getReleaseStatus() {
        return releaseStatus;
    }

    @Override
    public String getOwnerUsername() {
        return authorName;
    }

    @Override
    public void setOwnerUsername(String username) {
        authorName = username;
    }
}
