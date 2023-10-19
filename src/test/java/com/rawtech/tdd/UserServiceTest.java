package com.rawtech.tdd;

import com.rawtech.tdd.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @DisplayName("User object created and name correct.")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObjectAndFirstName() {
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
        assertNotNull(user, "createUser() should have returned a User object");
        assertEquals(firstName, user.getFirstName(), "User's'first name is not correct ");
        assertEquals(lastName, user.getLastName(), "User's last name is not correct ");

    }

}
