package com.example.Elden.Ring.service;

import com.example.Elden.Ring.dto.request.UserCreateRequest;
import com.example.Elden.Ring.entity.User;
import com.example.Elden.Ring.exception.AppException;
import com.example.Elden.Ring.exception.ErrorCode;
import com.example.Elden.Ring.mapper.UserMapper;
import com.example.Elden.Ring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserMapper userMapper;

    public User create(UserCreateRequest createRequest) {

            if(userRepository.existsByUsername(createRequest.getUsername()))
                throw new AppException(ErrorCode.USER_EXISTED);
            if(userRepository.existsByEmail(createRequest.getEmail()))
                throw new AppException(ErrorCode.EMAIL_EXISTED);
            User user = userMapper.toUser(createRequest);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(createRequest.getPassword()));
          return userRepository.save(user);


    }
}