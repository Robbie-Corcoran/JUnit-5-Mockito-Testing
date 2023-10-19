package com.rawtech.tdd;

import com.rawtech.tdd.model.User;

public class UserServiceImpl implements UserService {


    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatedPassword ) {


        return new User();
    }
}
