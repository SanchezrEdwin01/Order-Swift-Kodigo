package com.example.orderswift.service.user;

import com.example.orderswift.model.User;
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

    public Optional<User> getUser(int userId){
        return userRepository.findById(userId);
    }

    public void saveOrUpdate(User user){
        userRepository.save(user);
    }

    public void delete(int userId){
        userRepository.deleteById(userId);
    }

}
