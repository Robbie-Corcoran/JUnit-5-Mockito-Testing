package com.rawtech.mockito.service;

import com.rawtech.mockito.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, String email, String userId, String password, String repeatedPassword) throws UserServiceException;

}
