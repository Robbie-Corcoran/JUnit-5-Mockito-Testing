package com.rawtech.tdd;

import com.rawtech.tdd.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @DisplayName("User object created and details correct.")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObjectAndDetails() {
//        Arrange
        UserService userService = new UserServiceImpl();

        String firstName = "Robbie";
        String lastName = "Corcoran";
        String email = "robbie@robbie.com";
        String password = "123456789";
        String repeatedPassword = "123456789";

//        Act
        User user = userService.createUser(firstName, lastName, email, UUID.randomUUID().toString());

//        Assert
        assertNotNull(user, "createUser() should have returned a User object");
        assertNotNull(user.getUserId(), "UserId should not be null");
        assertEquals(user.getFirstName(), user.getFirstName(), "User's'first name is not correct ");
        assertEquals(user.getLastName(), user.getLastName(), "User's last name is not correct ");
        assertEquals(user.getEmail(), user.getEmail(), "User's email is not correct ");

    }

}
