package com.isp392.ecommerce.service;
//import class

import com.isp392.ecommerce.dto.request.UserCreationRequest;
import com.isp392.ecommerce.dto.request.UserUpdateRequest;
import com.isp392.ecommerce.entity.User;
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

    public User create(UserCreationRequest createRequest) {
        if (userRepository.existsByUsername(createRequest.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        if (userRepository.existsByEmail(createRequest.getEmail()))
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        User user = userMapper.toUser(createRequest);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(createRequest.getPassword()));
        return userRepository.save(user);
    }
    //CHÚ Ý
//    public User createUser(UserCreationRequest request) {
//        User user = new User();
//        user.setFullName(request.getFullName());
//        user.setUsername(request.getUsername());
//        user.setRole(request.getRole());
//        user.setPassword(request.getPassword());
//        user.setPhone(request.getPhone());
//        user.setEmail(request.getEmail());
//        user.setCartId(request.getCartId());
//
//        return userRepository.save(user);
//    }

    public User updateUser(String id, UserUpdateRequest request) {
        User user = getUserById(id);

        user.setFullName(request.getFullName());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}