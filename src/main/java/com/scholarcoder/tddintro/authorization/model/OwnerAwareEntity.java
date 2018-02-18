package com.scholarcoder.tddintro.authorization.model;

public interface OwnerAwareEntity {
    String getOwnerUsername();

    void setOwnerUsername(String username);
}
