package com.isp392.ecommerce.service;
//import class

import com.isp392.ecommerce.dto.request.UserCreationRequest;
import com.isp392.ecommerce.dto.request.UserUpdateRequest;
import com.isp392.ecommerce.dto.response.UserResponse;
import com.isp392.ecommerce.entity.User;
import com.isp392.ecommerce.enums.Role;
import com.isp392.ecommerce.exception.AppException;
import com.isp392.ecommerce.exception.ErrorCode;
import com.isp392.ecommerce.mapper.UserMapper;
import com.isp392.ecommerce.repository.UserRepository;
//framework
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//return type
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {// findById() return Optional DType
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserResponse create(UserCreationRequest createRequest) {
        if (userRepository.existsByUsername(createRequest.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        if (userRepository.existsByEmail(createRequest.getEmail()))
            throw new AppException(ErrorCode.EMAIL_EXISTED);
//        if(userRepository.existsByPhone(createRequest.getPhone()))
//            throw new AppException(ErrorCode.PHONEEXISTED);

        User user = userMapper.toUser(createRequest);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(createRequest.getPassword()));

//        HashSet<String> roles = new HashSet<>();
//        roles.add(Role.CUSTOMER.name());
//        user.setRole(roles);

        return userMapper.toUserResponse(user);
    }


    public User updateUser(String id, UserUpdateRequest request) {

        User user = getUserById(id);
        if(!(request.getFullName().isEmpty() || request.getFullName().isBlank())){
            user.setFullName(request.getFullName());
        }else throw new AppException(ErrorCode.FULLNAMEEMPTY);
        if(!(request.getPhone().isEmpty() || request.getPhone().isBlank())){
            user.setPhone(request.getPhone());
        }else throw new AppException(ErrorCode.PHONEEMPTY);
        if(!(request.getAddress().isEmpty() || request.getAddress().isBlank())){
            user.setAddress(request.getAddress());
        }else throw new AppException(ErrorCode.ADDRESSEMPTY);

        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}