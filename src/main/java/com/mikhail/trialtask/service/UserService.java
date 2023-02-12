package com.mikhail.trialtask.service;


import com.mikhail.trialtask.dto.UserDTO;
import com.mikhail.trialtask.entity.User;

public interface UserService {
    User createUser(UserDTO userDTO);
    User findUserByEmail(String email);
}
