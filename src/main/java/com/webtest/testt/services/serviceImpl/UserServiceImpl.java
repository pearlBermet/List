package com.webtest.testt.services.serviceImpl;

import com.webtest.testt.models.User;
import com.webtest.testt.repository.UserRepository;
import com.webtest.testt.services.UserService;
import exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
     UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
          return userRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("User", "Id", id));
    }


}