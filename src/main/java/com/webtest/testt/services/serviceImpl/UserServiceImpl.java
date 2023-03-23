package com.webtest.testt.services.serviceImpl;

import com.webtest.testt.models.User;
import com.webtest.testt.repository.UserRepository;
import com.webtest.testt.services.UserService;
import exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//        Optional<User> user = userRepository.findById(id);
//        if(user.isPresent()){
//           return user.get();
//        }else{
//            throw new ResourceNotFoundException("User", "Id", id);
//        }

          return userRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("User", "Id", id));

    }

    @Override
    public User updateUser(User user, long id) {

        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", id));

        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setPassword(user.getPassword());
        //save existing user to DB
        userRepository.save(existingUser);
        return existingUser;
    }
}