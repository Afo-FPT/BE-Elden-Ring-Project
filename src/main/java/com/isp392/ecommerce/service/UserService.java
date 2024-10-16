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
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//return type
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {// findById() return Optional DType
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User create(UserCreationRequest createRequest) {
        if(userRepository.existsByPhone(createRequest.getPhone()))
            throw new AppException(ErrorCode.PHONEEXISTED);
        if (userRepository.existsByUsername(createRequest.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        if (userRepository.existsByEmail(createRequest.getEmail()))
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        User user = userMapper.toUser(createRequest);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(createRequest.getPassword()));

        user.setRole(Role.CUSTOMER.name());

        return userRepository.save(user);
    }

    public UserResponse getMyInfo() {
        return userMapper.toUserResponse(getCurrentUser());
    }

    public UserResponse updateMyInfo(UserUpdateRequest updateRequest) {
        User user = getCurrentUser();
        userMapper.updateUser(user, updateRequest);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public User updateUser(String id, UserUpdateRequest request) {

//        User user = getUserById(id);
//        if(!(request.getFullName().isEmpty() || request.getFullName().isBlank())){
//            user.setFullName(request.getFullName());
//        }else throw new AppException(ErrorCode.FULLNAMEEMPTY);
//        if(!(request.getPhone().isEmpty() || request.getPhone().isBlank())){
//            user.setPhone(request.getPhone());
//        }else throw new AppException(ErrorCode.PHONEEMPTY);
//        if(!(request.getAddress().isEmpty() || request.getAddress().isBlank())){
//            user.setAddress(request.getAddress());
//        }else throw new AppException(ErrorCode.ADDRESSEMPTY);
//
//        return userRepository.save(user);
        return null;
    }

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}