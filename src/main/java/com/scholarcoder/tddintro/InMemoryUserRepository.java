package com.scholarcoder.tddintro;

public class InMemoryUserRepository implements UserRepository {
    @Override
    public User findByUsername(String username) {
        return new User();
    }
}
