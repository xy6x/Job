package com.example.jobseek.Service;

import com.example.jobseek.Model.User;
import com.example.jobseek.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    public List<User> getUser(){

        return userRepository.findAll();
    }
    public void addUser(User user){

        userRepository.save(user);
    }
    public Boolean updateUser(Integer id,User user){
        User oldUser =userRepository.getById(id);
        if (oldUser == null) {
            return false;
        }
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        userRepository.save(oldUser);
        return true;
    }
    public Boolean deleteUser(Integer id){
        User user =userRepository.getById(id);
        if (user == null) {
            return false;

        }
        userRepository.delete(user);
        return true;
    }
}
