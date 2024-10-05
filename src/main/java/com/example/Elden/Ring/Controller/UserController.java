package com.example.Elden.Ring.Controller;

import com.example.Elden.Ring.dto.request.UserCreateRequest;
import com.example.Elden.Ring.dto.respnse.ApiResponse;
import com.example.Elden.Ring.entity.User;
import com.example.Elden.Ring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin  //cross port

    @PostMapping("/create-user")
    ApiResponse<User> create(@RequestBody @Valid UserCreateRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.create(request));

        return apiResponse;

        }
}
