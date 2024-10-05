package com.example.Elden.Ring.mapper;

import com.example.Elden.Ring.dto.request.UserCreateRequest;
import com.example.Elden.Ring.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest createRequest);

}
