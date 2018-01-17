package com.scholarcoder.tddintro;

public class UserService {
    public Session session;

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(String username, String password) {
        User foundUser = userRepository.findByUsername(username);

        if(foundUser==null)
            throw new UserNotFoundException(String.format("User with username %s could not be found!", username));

        if(foundUser.username.equals(username) && foundUser.password.equals(password)) {
            session = new Session();
            session.user = new User();
            session.user.username = foundUser.username;
            session.user.password = foundUser.password;
        }
        else throw new AuthenticationFailureException("Provided password was incorrect!");
    }
}
