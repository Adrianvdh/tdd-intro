package com.scholarcoder.tddintro.authentication;

import com.scholarcoder.tddintro.authentication.exception.AuthenticationFailureException;
import com.scholarcoder.tddintro.authentication.exception.UserNotFoundException;
import com.scholarcoder.tddintro.user.Session;
import com.scholarcoder.tddintro.user.model.User;
import com.scholarcoder.tddintro.user.repository.UserRepository;

public class AuthenticationService {
    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(String username, String password) {
        User foundUser = userRepository.findByUsername(username);

        if(foundUser==null) {
            throw new UserNotFoundException(String.format("User with username %s could not be found!", username));
        }

        if(foundUser.username.equals(username) && foundUser.password.equals(password)) {
            Session session = Session.getCurrentSession();
            session.setAuthenticatedUser(foundUser);
        }
        else {
            throw new AuthenticationFailureException("Provided password was incorrect!");
        }
    }
}
