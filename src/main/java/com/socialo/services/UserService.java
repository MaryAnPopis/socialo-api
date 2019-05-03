package com.socialo.services;

import com.socialo.dto.UserDTO;
import com.socialo.models.User;

import java.util.Optional;

public interface UserService {
    Object create(User user);
    boolean isPresent(User user);
    Object login(User user);
    Optional<UserDTO> getById(Long id);
}
