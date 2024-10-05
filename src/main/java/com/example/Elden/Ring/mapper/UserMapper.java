package com.example.Elden.Ring.mapper;

import com.example.Elden.Ring.dto.request.UserCreateRequest;
import com.example.Elden.Ring.dto.respnse.UserResponse;
import com.example.Elden.Ring.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toUser(UserCreateRequest userCreateRequest);
    //còn 1 cái loz nữa ở đây để map mấy cái như update delete
    UserResponse toUserResponse(User user);


}
