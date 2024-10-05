package com.example.Elden.Ring.service;

import com.example.Elden.Ring.dto.request.UserCreateRequest;
import com.example.Elden.Ring.entity.User;
import com.example.Elden.Ring.exception.AppException;
import com.example.Elden.Ring.exception.ErrorCode;
import com.example.Elden.Ring.mapper.UserMapper;
import com.example.Elden.Ring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public User create(UserCreateRequest userCreateRequest){
        if(userRepository.existsByUsername(userCreateRequest.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(userCreateRequest);
       return userRepository.save(user);
    }
}
