package com.webtest.testt.services;

import com.webtest.testt.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService extends UserDetails {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(Long id);
}
