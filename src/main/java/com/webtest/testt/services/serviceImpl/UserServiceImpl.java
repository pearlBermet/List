package com.webtest.testt.services.serviceImpl;

import com.webtest.testt.models.User;
import com.webtest.testt.repository.UserRepository;
import com.webtest.testt.services.UserService;
import exception.ResourceNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

//    @Override
//    public User updateUser(Long id) {
//
//        User existingUser = userRepository.findById(id);
//
//        existingUser.setName(existingUser.getName());
//        existingUser.setSurname(existingUser.getSurname());
//        existingUser.setPassword(existingUser.getPassword());
//        existingUser.setGrade(existingUser.getGrade());
//        existingUser.setAbsence(existingUser.getAbsence());
//        existingUser.setBonus(existingUser.getBonus());
//        //save existing user to DB
//        userRepository.save(existingUser);
//        return existingUser;
//    }

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if(user == null) {

            throw new UsernameNotFoundException("Wrong password or name");

        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}