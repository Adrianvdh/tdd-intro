package com.scholarcoder.tddintro.user.repository;

import com.scholarcoder.tddintro.user.model.User;

public interface UserRepository {
    User findByUsername(String username);
}
