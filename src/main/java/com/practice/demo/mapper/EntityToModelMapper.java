package com.practice.demo.mapper;

import com.practice.demo.entity.UserEntity;
import com.practice.demo.model.User;

public class EntityToModelMapper {

    public static User mapToUser(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getLogin()
        );
    }

}
