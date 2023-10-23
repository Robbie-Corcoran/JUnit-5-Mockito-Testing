package com.rawtech.mockito.model;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String userId;
    private final String password;
    private final String repeatedPassword;

    public User(String firstName, String lastName, String email, String userId, String password, String repeatedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
}
