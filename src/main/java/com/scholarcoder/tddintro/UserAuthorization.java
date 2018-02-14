package com.scholarcoder.tddintro;

public class UserAuthorization {

    private User currentUser = Session.getCurrentSession().getAuthenticatedUser();

    public void requiresAuthentication() {
        if(currentUser==null) {
            throw new AuthenticationRequiredException("This method requires a user to be logged in first!");
        }
    }

    public void userIsOwner(String ownerUsername) {
        requiresAuthentication();

        if(!ownerUsername.equals(currentUser.username)) {
            throw new AuthorizationFailedException("The current user is not the owner!");
        }
    }
}
