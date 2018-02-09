package com.scholarcoder.tddintro;

public class UserAuthorization {

    private User user;

    public UserAuthorization() {
        Session session = Session.getCurrentSession();
        this.user = session.getAuthenticatedUser();
    }

    public void requiresAuthentication() {
        if(user == null) {
            throw new AuthenticationRequiredException("No one is logged in to perform this operation!");
        }
    }

    public void requiresOwner(String ownerName) {
        requiresAuthentication();

        if(!ownerName.equals(user.username)) {
            throw new AuthorizationFailedException("Logged in user is not the owner!");
        }
    }
}
