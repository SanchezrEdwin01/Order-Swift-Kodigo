package com.example.orderswift.controller;

import com.example.orderswift.model.User;
import com.example.orderswift.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "User",  description = "This controller makes a CRUD of user")
@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private  UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(description = "This controller gets the list of all the users")
    @GetMapping
    public List<User> getAll(){
        return userService.getUsers();
    }

    @Operation(description = "This controller updates a user by its id")
    @PostMapping("/update")
    public void saveUpdate(@Valid @RequestBody User user){
         userService.saveOrUpdate(user);
    }

    @Operation(description = "This controller deletes user by its id")
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") int userId){
        userService.delete(userId);
    }

    @Operation(description = "This controller get a user by its id")
    @GetMapping("/{userId}")
    public Optional<User> getById(@PathVariable("userId") int userId){
        return userService.getUser(userId);
    }
}
