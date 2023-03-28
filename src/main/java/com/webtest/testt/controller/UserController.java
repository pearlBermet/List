package com.webtest.testt.controller;

import com.webtest.testt.models.User;
import com.webtest.testt.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/userr")
public class UserController {

//    @GetMapping("/user")
//    public User getUser() {
//        return new User("Bermet", "Nurbekovna", 3101);
//    }
//
//    @GetMapping("/users")
//    public List<User> getUsers(){
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("Bermet","Nurbekova",3101));
//        users.add(new User("Isken","Nurbekov",3119));
//        users.add(new User("Eldar","Nurbekov",3120));
//        return users;
//    }
//
//    @GetMapping("/user{name}/{surname}/{password}/")
//    public User userPathVariable(@PathVariable("name") String name, @PathVariable("surname") String surname,@PathVariable("password") Integer password) {
//        return new User(name,surname,password);
//    }
//
//    @GetMapping("/user/query")
//    public User userQueryParam(@RequestParam(name = "name")String name,
//                               @RequestParam(name = "surname") String surname,
//                               @RequestParam(name = "password") Integer password) {
//        return new User(name,surname,password);
//    }

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //build create user REST API
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    //Get all employees REST API
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //biuld get user by id REST API
    //hhtp://localhost:8080/api/userr/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
        return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
    }

    //build update user REST API
    // hhtp://localhost:8080/api/userr/1
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id){
        return new ResponseEntity<User>(userService.updateUser(id), HttpStatus.OK);

    }







}
