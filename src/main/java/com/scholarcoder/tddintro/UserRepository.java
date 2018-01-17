package com.scholarcoder.tddintro;

public interface UserRepository {
    User findByUsername(String username);
}
