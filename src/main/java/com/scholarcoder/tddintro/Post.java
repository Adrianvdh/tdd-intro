package com.scholarcoder.tddintro;

public class Post {

    public ReleaseStatus releaseStatus = ReleaseStatus.DRAFT;
    public String authorUserName;


    public Post(String title, String body, String authorUserName) {
        this.authorUserName = authorUserName;
    }
}
