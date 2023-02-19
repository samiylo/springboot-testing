package com.searchapi.demo.controller;

import com.searchapi.demo.dbrepo.User;
import com.searchapi.demo.dbrepo.UserRepository;
import com.searchapi.demo.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/{id}")//Get user by id
    public User getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return  user.get();
        } else {
            throw new RuntimeException(" ::: User " + id + " not found ::: ");
        }

    }

    @PutMapping("/{id}")//Create user
    public User updateUserById(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(" ::: User " + id + " not found ::: "));
        user.setName(updatedUser.getName());
        user.setCompleted(updatedUser.isCompleted());
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")//Delete user
    public void deleteUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(" ::: User " + id + " not found ::: "));
        userRepository.delete(user);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceNotFoundException exception) {
        return exception.getMessage();
    }
}
