package com.rawtech.mockito;

import com.rawtech.tdd.UserService;
import com.rawtech.tdd.UserServiceImpl;
import com.rawtech.tdd.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    com.rawtech.tdd.UserService userService;
    String firstName;
    String lastName;
    String email;

    @BeforeEach
    void setup() {
        userService = new com.rawtech.tdd.UserServiceImpl();

        firstName = "Robbie";
        lastName = "Corcoran";
        email = "robbie@robbie.com";
    }

    @DisplayName("User object created and details correct.")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObjectAndDetails() {
//        Arrange


//        Act
        User user = userService.createUser(firstName, lastName, email, UUID.randomUUID().toString());

//        Assert
        assertNotNull(user, "createUser() should have returned a User object");
        assertNotNull(user.getUserId(), "UserId should not be null");
        assertEquals(user.getFirstName(), user.getFirstName(), "User's'first name is not correct ");
        assertEquals(user.getLastName(), user.getLastName(), "User's last name is not correct ");
        assertEquals(user.getEmail(), user.getEmail(), "User's email is not correct ");

    }

    @DisplayName("Empty first name throws correct exception.")
    @Test
    void testCreatUser_whenUserFirstNameIsEmpty_ThrowIllegalArgumentException() {
//        Arrange
        UserService userService = new UserServiceImpl();

        String firstName = "";
        String expectedExceptionMessage = "First name cannot be empty.";

//        Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userService.createUser(firstName, lastName, email, UUID.randomUUID().toString()),
                "Missing first name should throw IllegalArgumentException.");

//        Assert
        assertEquals(expectedExceptionMessage, thrown.getMessage(), "IllegalArgumentException did not display the correct message");
    }

    @DisplayName("Empty last name throws correct exception.")
    @Test
    void testCreateUser_whenUserLastNameIsEmpty_ShouldThrowIllegalArgumentException() {
//        Arrange
        String lastName = "";
        String expectedExceptionMessage = "Last name cannot be empty.";


//        Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()->
                userService.createUser(firstName, lastName, email, UUID.randomUUID().toString()),
                "Missing last name should throw IllegalArgumentException.");

//        Assert
        assertEquals(expectedExceptionMessage, thrown.getMessage(), "IllegalArgumentException did not display the correct message");

    }
}
