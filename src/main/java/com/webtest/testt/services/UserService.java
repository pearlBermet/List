package com.webtest.testt.services;

import com.webtest.testt.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
