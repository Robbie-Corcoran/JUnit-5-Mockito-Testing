package com.rawtech.mockito.service;

import com.rawtech.mockito.data.UserRepository;
import com.rawtech.mockito.model.User;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String userId, String password, String repeatedPassword){
        if(firstName.isBlank() || firstName.isEmpty()){
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if(lastName.isBlank() || lastName.isEmpty()){
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        User user = new User(firstName, lastName, email, userId, password, repeatedPassword);

        boolean isUserCreated = userRepository.save(user);


        if(!isUserCreated) throw new UserServiceException("Could not create user");

        return user;
    }
}
