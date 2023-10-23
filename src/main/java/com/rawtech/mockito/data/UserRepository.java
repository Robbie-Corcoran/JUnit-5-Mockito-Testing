package com.rawtech.mockito.data;

import com.rawtech.mockito.model.User;

public interface UserRepository {
    boolean save(User user);
}
