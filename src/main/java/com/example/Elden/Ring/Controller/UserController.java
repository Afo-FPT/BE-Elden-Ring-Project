package com.example.Elden.Ring.Controller;

import com.example.Elden.Ring.request.UserCreateRequest;
import com.example.Elden.Ring.service.UserService;
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
        String create ( @RequestBody UserCreateRequest request){
            userService.create(request);
            return "created";
        }
}
