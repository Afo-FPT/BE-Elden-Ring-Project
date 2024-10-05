package com.example.Elden.Ring.service;

import com.example.Elden.Ring.dto.request.UserCreateRequest;
import com.example.Elden.Ring.entity.User;
import com.example.Elden.Ring.exception.AppException;
import com.example.Elden.Ring.exception.ErrorCode;
import com.example.Elden.Ring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(UserCreateRequest userCreateRequest){

        User user = User.builder()
                .username(userCreateRequest.getUsername())
                .password(userCreateRequest.getPassword())
                .email(userCreateRequest.getEmail())
                .build();
        if(userRepository.existsByUsername(userCreateRequest.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

       return userRepository.save(user);
    }
}
