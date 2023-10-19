package com.rawtech.mockito.data;

import com.rawtech.mockito.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    Map<String, User> users = new HashMap<>();

    @Override
    public boolean save(User user) {
        boolean returnValue = false;

        if(!users.containsKey(user.getUserId())){
            users.put(user.getUserId(), user);
            returnValue = true;
        }
        return returnValue;
    }
}
