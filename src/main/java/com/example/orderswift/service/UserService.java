package com.example.orderswift.service;

import com.example.orderswift.entity.User;
import com.example.orderswift.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
       return userRepository.findAll();
    }

    public Optional<User> getUser(Long userId){
        return userRepository.findById(userId);
    }

    public void saveOrUpdate(User user){
        userRepository.save(user);
    }

    public void delete(Long userId){
        userRepository.deleteById(userId);
    }

}
