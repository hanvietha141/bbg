package com.bbg.service;

import com.bbg.dto.UserDTO;

import java.util.ArrayList;

public interface IUserService {
    UserDTO save(UserDTO userDTO);
    ArrayList<UserDTO> getUser();
    ArrayList<UserDTO> getUser(String oderDirection);
    Object getUserById(int id) throws Exception;
    boolean deleteUser(int id);
}
