package com.scholarcoder.tddintro;

public class Session {
    private static Session currentSession;
    private Object authenticatedUser;

    public static Session getCurrentSession() {
        return currentSession;
    }

    public Object getAuthenticatedUser() {
        return authenticatedUser;
    }
}
