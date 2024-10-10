package com.isp392.ecommerce.mapper;

import com.isp392.ecommerce.dto.request.UserCreationRequest;
import com.isp392.ecommerce.dto.response.UserResponse;
import com.isp392.ecommerce.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest userCreationRequest);
    //còn 1 cái loz nữa ở đây để map mấy cái như update delete
    UserResponse toUserResponse(User user);



}
