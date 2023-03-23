package com.webtest.testt.services;

import com.webtest.testt.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(User user, long id);
}
