package com.tierrayaire.service;

import com.tierrayaire.model.Concert;
import com.tierrayaire.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findByEmail(String email);
    String encodePassword(String password);
}
