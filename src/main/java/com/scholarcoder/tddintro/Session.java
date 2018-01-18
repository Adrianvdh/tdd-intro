package com.scholarcoder.tddintro;

public class Session {
    private static Session instance = null;
    public User user;

    private Session() { }

    public static Session getCurrentSession() {
        if(instance==null)
            instance = new Session();
        return instance;
    }
}
