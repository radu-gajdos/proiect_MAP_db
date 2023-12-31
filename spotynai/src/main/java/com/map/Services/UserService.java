package com.map.Services;

import com.map.Domain.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);

    List<UserEntity> findAll();

    Optional<UserEntity> findOne(Long id);

    boolean isExists(Long id);

    void delete(Long id);

    boolean authenticateUser(String username, String password);

    boolean isUsernameTaken(String username);

    Long getUserIdByUsername(String username);

}
