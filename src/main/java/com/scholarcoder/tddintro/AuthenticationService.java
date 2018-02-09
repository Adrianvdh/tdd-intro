package com.scholarcoder.tddintro;

public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(String username, String password) {
        User foundUser = userRepository.findByUsername(username);

        if(foundUser==null)
            throw new UserNotFoundException(String.format("User with username %s could not be found!", username));

        if(foundUser.username.equals(username) && foundUser.password.equals(password)) {
            Session session = Session.getCurrentSession();
            session.setAuthenticatedUser(foundUser);
        }
        else throw new AuthenticationFailureException("Provided password was incorrect!");
    }

    public void preAuthorize() {
        Session currentSession = Session.getCurrentSession();
        if(currentSession.getAuthenticatedUser()==null)
            throw new AuthorizationRequiredException("User is not authenticated!");
    }
}
