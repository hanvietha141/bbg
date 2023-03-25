package com.bbg.service;

import com.bbg.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    Object save(UserDTO userDTO) throws Exception;
    ArrayList<UserDTO> getUser();
    ArrayList<UserDTO> getUser(String oderDirection);
    Object getUserById(int id) throws Exception;
    boolean deleteUser(int id);

    Object setUserFollow(int userId, List<Integer> talentIds) throws Exception;
}
