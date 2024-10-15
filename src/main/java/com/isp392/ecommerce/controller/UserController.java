package com.isp392.ecommerce.controller;
//import class

import com.isp392.ecommerce.dto.request.UserCreationRequest;
import com.isp392.ecommerce.dto.request.UserUpdateRequest;
import com.isp392.ecommerce.dto.response.ApiResponse;
import com.isp392.ecommerce.dto.response.UserResponse;
import com.isp392.ecommerce.entity.User;
import com.isp392.ecommerce.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/*
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
*/
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin  //cross port

    @PostMapping
    ApiResponse<User> create(@RequestBody @Valid UserCreationRequest createRequest) {
        return ApiResponse.<User>builder()
                .result(userService.create(createRequest))
                .build();
    }

    @GetMapping("/my-info")
    ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("/update-my-info")
    ApiResponse<UserResponse> updateMyInfo(@RequestBody UserUpdateRequest updateRequest) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateMyInfo(updateRequest))
                .build();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
