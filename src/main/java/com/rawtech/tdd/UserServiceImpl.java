package com.rawtech.tdd;

import com.rawtech.tdd.model.User;

public class UserServiceImpl implements UserService {


    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatedPassword ) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRepeatedPassword(repeatedPassword);

        return user;
    }
}
