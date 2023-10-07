package com.practice.demo.repository;

import com.practice.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByName(String name);

}
