package com.rawtech.tdd;

import com.rawtech.tdd.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, String email, String userId);

}
