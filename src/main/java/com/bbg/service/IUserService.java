package com.bbg.service;

import com.bbg.Requestbody.RequestbodySetFollowing;
import com.bbg.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    Object save(UserDTO userDTO) throws Exception;
    ArrayList<UserDTO> getUser();
    ArrayList<UserDTO> getUser(String oderDirection);
    Object getUserById(int id) throws Exception;
    boolean deleteUser(int id);

    Object setUserFollowing(RequestbodySetFollowing model);
}
