package com.rawtech.tdd;

import com.rawtech.tdd.model.User;

public class UserServiceImpl implements UserService {


    @Override
    public User createUser(String firstName, String lastName, String email, String userId) {
        if(firstName.isBlank() || firstName.isEmpty()){
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if(lastName.isBlank() || lastName.isEmpty()){
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        return new User(firstName, lastName, email, userId);
    }
}
