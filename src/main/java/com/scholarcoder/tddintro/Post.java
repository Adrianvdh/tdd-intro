package com.scholarcoder.tddintro;

public class Post implements OwnerAwareEntity {

    public ReleaseStatus releaseStatus;
    private String authorName;

    public Post(String title, String body, String authorUsername) {
        this.authorName = authorUsername;
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
        this.authorName = username;
    }
}
