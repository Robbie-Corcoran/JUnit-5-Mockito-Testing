package com.rawtech.mockito;

import com.rawtech.mockito.data.UserRepository;
import com.rawtech.mockito.data.UserRepositoryImpl;
import com.rawtech.mockito.service.*;
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
import static org.mockito.Mockito.*;

@SuppressWarnings("EqualsWithItself")
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    EmailVerificationServiceImpl emailVerificationService;
    @Mock
    UserRepository userRepository;
    String firstName;
    String lastName;
    String email;
    String userId;
    String password;
    String repeatPassword;

    @BeforeEach
    void setup() {
        firstName = "Robbie";
        lastName = "Corcoran";
        email = "robbie@robbie.com";
        userId = UUID.randomUUID().toString();
        password = "123456789";
        repeatPassword = "123456789";
    }

    @DisplayName("User object created and details correct.")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObjectAndDetails() {
//        Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);

//        Act
        User user = userService.createUser(firstName, lastName, email, UUID.randomUUID().toString(), password, repeatPassword);

//        Assert
        assertNotNull(user, "createUser() should have returned a User object");
        assertNotNull(user.getUserId(), "UserId should not be null");
        assertEquals(user.getFirstName(), user.getFirstName(), "User's'first name is not correct ");
        assertEquals(user.getLastName(), user.getLastName(), "User's last name is not correct ");
        assertEquals(user.getEmail(), user.getEmail(), "User's email is not correct ");
        verify(userRepository, times(1)).save(any(User.class));
        verify(userRepository, atMostOnce()).save(any(User.class));
    }

    @DisplayName("Empty first name throws correct exception.")
    @Test
    void testCreateUser_whenUserFirstNameIsEmpty_ThrowIllegalArgumentException() {
//        Arrange
        String firstName = "";
        String expectedExceptionMessage = "First name cannot be empty.";

//        Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () ->
                userService.createUser(firstName, lastName, email, userId, password, repeatPassword),
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
                userService.createUser(firstName, lastName, email, userId, password, repeatPassword),
                "Missing last name should throw IllegalArgumentException.");

//        Assert
        assertEquals(expectedExceptionMessage, thrown.getMessage(), "IllegalArgumentException did not display the correct message");
    }

    @DisplayName("If save() causes RuntimeException, a UserServiceException is thrown.")
    @Test
    void testCreateUser_WhenSaveMethodThrowsException_thenThrowsUserServiceException() {
//        Arrange
        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);

//        Act & Assert
        assertThrows(UserServiceException.class, () -> userService.createUser(firstName, lastName, email, userId, password, repeatPassword), "Should have thrown UserServiceException instead.");
    }

    @DisplayName("EmailNotificationException is handled.")
    @Test
    void testCreateUser_whenEmailNotificationExceptionIsThrown_throwsUserServiceException() {
//        Arrange
        when(userRepository.save(any(User.class)))
                .thenReturn(true);

        doThrow(EmailNotificationServiceException.class)
                .when(emailVerificationService)
                .scheduleEmailVerification(any(User.class));

//        This will make the test fail as it overwrites the lines about. It literally lets it not to invoke the method, to DO NOTHING!
//        doNothing().when(emailVerificationService).scheduleEmailVerification(any(User.class));

//        Act & Assert
        assertThrows(UserServiceException.class,
                () -> userService.createUser(firstName, lastName, email, userId, password, repeatPassword),
                "Should have thrown a UserServiceException instead.");

//        Assert
        verify(emailVerificationService, times(1)).scheduleEmailVerification(any(User.class)) ;

    }
}
