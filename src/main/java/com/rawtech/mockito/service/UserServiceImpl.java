package com.rawtech.mockito.service;

import com.rawtech.mockito.data.UserRepository;
import com.rawtech.mockito.model.User;

public class  UserServiceImpl implements UserService {
    UserRepository userRepository;
    EmailVerificationService emailVerificationService;


    public UserServiceImpl(UserRepository userRepository, EmailVerificationService emailVerificationService) {
        this.userRepository = userRepository;
        this.emailVerificationService = emailVerificationService;
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

        boolean isUserCreated;
        try {
            isUserCreated = userRepository.save(user);
        } catch (RuntimeException ex) {
            throw new UserServiceException(ex.getMessage());
        }

        if(!isUserCreated) throw new UserServiceException("Could not create user");

        try {
            emailVerificationService.scheduleEmailVerification(user);
        } catch (RuntimeException ex) {
            throw new UserServiceException(ex.getMessage());
        }

        return user;
    }
}
