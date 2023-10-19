package com.rawtech.tdd;

import com.rawtech.tdd.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject() {
//        Arrange
        UserService userService = new UserServiceImpl();

        String firstName = "Robbie";
        String lastName = "Corcoran";
        String email = "robbie@robbie.com";
        String password = "123456789";
        String repeatedPassword = "123456789";

//        Act
        User user = userService.createUser(firstName, lastName, email, password, repeatedPassword);

//        Assert
        assertNotNull(user, "createuser() should have returned a User object");


    }
}
