package com.bbg.converter;

import com.bbg.dto.UserDTO;
import com.bbg.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity toEntity(UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.getId());
        userEntity.setAge(dto.getAge());
        userEntity.setName(dto.getName());
        return  userEntity;
    }

    public UserDTO toDTO(UserEntity entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(entity.getAge());
        userDTO.setId(entity.getId());
        userDTO.setName(entity.getName());
        return userDTO;
    }
}
