package com.bbg.service.impl;

import com.bbg.converter.UserConverter;
import com.bbg.dto.UserDTO;
import com.bbg.entity.UserEntity;
import com.bbg.repository.UserRepository;
import com.bbg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

//    @PostConstruct
//    public void init() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setAge(1);
//        userDTO.setName("a");
//        UserEntity userEntity = userConverter.toEntity(userDTO);
//        userRepository.save(userEntity);
//    }
    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = userConverter.toEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return userConverter.toDTO(userEntity);
    }

    @Override
    public ArrayList<UserDTO> getUser() {
        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll();
        ArrayList<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (UserEntity userEntity : userEntities) {
            UserDTO userDTO = userConverter.toDTO(userEntity);
            userDTOList.add(userDTO);
            System.out.println(userDTO);
        }
        return userDTOList;
    }

    Comparator<UserDTO> compareByName = (UserDTO o1, UserDTO o2) -> o1.getName().compareTo( o2.getName() );

    @Override
    public ArrayList<UserDTO> getUser(String oderDirection) {
        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll();
        ArrayList<UserDTO> userDTOList = new ArrayList<UserDTO>();
        for (UserEntity userEntity : userEntities) {
            UserDTO userDTO = userConverter.toDTO(userEntity);
            userDTOList.add(userDTO);
            System.out.println(userDTO);
        }
        if (Objects.equals(oderDirection, "ASC")) {
            Collections.sort(userDTOList, compareByName);
        } else if (Objects.equals(oderDirection, "DESC")) {
            Collections.sort(userDTOList, compareByName.reversed());
        }
        return userDTOList;
    }

    @Override
    public UserDTO getUserById(int id) {
        UserEntity userEntity =  userRepository.getById(id);
        UserDTO userDTO = userConverter.toDTO(userEntity);
        return userDTO;
    }
}
