package com.upen.bean_validation_example.service;

import com.upen.bean_validation_example.dto.UserDto;
import com.upen.bean_validation_example.exception.UserNotFoundException;
import com.upen.bean_validation_example.model.User;
import com.upen.bean_validation_example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User createUser(UserDto userDto) {
        User user = new User(
                null,
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getGender(),
                userDto.getAge());
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long userId) throws UserNotFoundException {
        User user = repository.findById(userId).orElse(null);
        if (user != null) {
            return user;
        }
        else {
            throw new UserNotFoundException("User not found with id: " + userId);
        }
    }

}
