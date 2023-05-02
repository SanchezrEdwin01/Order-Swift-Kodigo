package com.example.orderswift.controller;

import com.example.orderswift.entity.User;
import com.example.orderswift.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private  UserService userService;
    @GetMapping
    public List<User> getAll(){
        return userService.getUsers();
    }

    @PostMapping
    public void saveUpdate(@RequestBody User user){
         userService.saveOrUpdate(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") Long userId){
        userService.delete(userId);
    }

    @GetMapping("/{userId}")
    public Optional<User> getById(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }
}
