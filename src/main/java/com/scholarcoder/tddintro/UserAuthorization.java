package com.scholarcoder.tddintro;

public class UserAuthorization {

    public void requiresAuthentication() {
        User currentUser = Session.getCurrentSession().getAuthenticatedUser();
        if(currentUser==null) {
            throw new AuthenticationRequiredException("This method requires a user to be logged in first!");
        }
    }
}
