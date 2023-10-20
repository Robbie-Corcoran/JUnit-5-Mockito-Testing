package com.rawtech.mockito.service;

import com.rawtech.mockito.model.User;

public interface EmailVerificationService {
    default void scheduleEmailVerification(User user) {}
}
