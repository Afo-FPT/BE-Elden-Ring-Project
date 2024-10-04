package com.example.Elden.Ring.service;

import com.example.Elden.Ring.entity.User;
import com.example.Elden.Ring.repository.UserRepository;
import com.example.Elden.Ring.request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void create(UserCreateRequest userCreateRequest){
        try {
            User user = User.builder()
                    .userId(userCreateRequest.getUserId())
                    .password(userCreateRequest.getPassword())
                    .email(userCreateRequest.getEmail())
                    .build();

            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Email already exists");
        }
    }
}
