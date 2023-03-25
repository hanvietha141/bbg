package com.bbg.converter;

import com.bbg.dto.UserDTO;
import com.bbg.entity.TalentEntity;
import com.bbg.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        List<TalentEntity> listFollowing = entity.getFollowing();
        ArrayList<Integer> listIdFollowing = new ArrayList<>();
        for(TalentEntity following : listFollowing) {
            listIdFollowing.add(following.getId());
        }
        userDTO.setFollowing(listIdFollowing);
        return userDTO;
    }
}
