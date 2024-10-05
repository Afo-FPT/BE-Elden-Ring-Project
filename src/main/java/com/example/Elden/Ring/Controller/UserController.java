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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin  //cross port

    @PostMapping("/create-user")
    ApiResponse<User> create(@RequestBody @Valid UserCreateRequest createRequest){

    return ApiResponse.<User>builder()
            .result(userService.create(createRequest))
            .build();


        }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
