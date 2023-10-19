package com.rawtech.mockito;

import com.rawtech.mockito.data.UserRepository;
import com.rawtech.mockito.service.UserService;
import com.rawtech.mockito.service.UserServiceImpl;
import com.rawtech.mockito.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void setup() {
        firstName = "Robbie";
        lastName = "Corcoran";
        email = "robbie@robbie.com";
        password = "123456789";
        repeatPassword = "123456789";
    }

    @DisplayName("User object created and details correct.")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObjectAndDetails() {
//        Arrange


//        Act
        User user = userService.createUser(firstName, lastName, email, UUID.randomUUID().toString(), password, repeatPassword);

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
        String firstName = "";
        String expectedExceptionMessage = "First name cannot be empty.";

//        Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userService.createUser(firstName, lastName, email, UUID.randomUUID().toString(), password, repeatPassword),
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
                userService.createUser(firstName, lastName, email, UUID.randomUUID().toString(), password, repeatPassword),
                "Missing last name should throw IllegalArgumentException.");

//        Assert
        assertEquals(expectedExceptionMessage, thrown.getMessage(), "IllegalArgumentException did not display the correct message");

    }
}
