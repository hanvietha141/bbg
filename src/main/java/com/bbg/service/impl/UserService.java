package com.bbg.service.impl;

import com.bbg.Requestbody.RequestbodySetFollowing;
import com.bbg.converter.UserConverter;
import com.bbg.dto.UserDTO;
import com.bbg.entity.TalentEntity;
import com.bbg.entity.UserEntity;
import com.bbg.exception.ApiRequestExeption;
import com.bbg.helper.ValidationHelper;
import com.bbg.repository.TalentRepository;
import com.bbg.repository.UserRepository;
import com.bbg.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TalentRepository talentRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private ValidationHelper validationHelper;

    @Override
    public Object save(UserDTO userDTO) {
        String[] strArray = new String[]{"f", "r", "u", "i", "t"};
        Boolean iSValidated = validationHelper.haveCharacters(strArray, 3, userDTO.getName());
        UserEntity userEntity = new UserEntity();
        if (iSValidated) {
            if (userDTO.getId() == 0) {
                userEntity = userConverter.toEntity(userDTO);
            } else {
                userEntity = userRepository.getById(userDTO.getId());
                UserDTO oldInfomation = userConverter.toDTO(userEntity);
                oldInfomation.setAge(userDTO.getAge());
                oldInfomation.setName(userDTO.getName());
                userEntity = userConverter.toEntity(oldInfomation);
            }
            userEntity = userRepository.save(userEntity);
        } else {
            throw new ApiRequestExeption("Invalid name");
        }

        if (!validationHelper.minMaxValue(userDTO.getAge())) {
            throw new ApiRequestExeption("Age must be less then 22 and greater than 20!");
        }
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

    Comparator<UserDTO> compareByName = (UserDTO o1, UserDTO o2) -> o1.getName().compareTo(o2.getName());

    @Override
    public ArrayList<UserDTO> getUser(String oderDirection) {
//        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll();
//        Page<UserEntity> userEntities =  userRepository.findAll(PageRequest.of(1, 2));
//        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        Page<UserEntity> userEntities = userRepository.findAll(PageRequest.of(0, 2).withSort(Sort.by(Sort.Direction.DESC, "name")));
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
    public Object getUserById(int id) throws Exception {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            UserDTO userDTO = userConverter.toDTO(userEntity);
            return userDTO;
        } else {
            throw new Exception("Not found");
        }
    }

    @Override
    public boolean deleteUser(int id) {
        boolean isExist = userRepository.existsById(id);
        System.out.println(isExist);
        if (isExist == true) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Object setUserFollowing(RequestbodySetFollowing model) throws Exception  {
        int userId = model.getUserId();
        List<Integer> talentIds = model.getTalentIds();
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        UserDTO userDTO = userConverter.toDTO(userEntity);
        List<TalentEntity> prevListFollowing = userEntity.getFollowing();
        ArrayList<TalentEntity> newListFollwing = new ArrayList<>();
        for(TalentEntity prevItemFollowing : prevListFollowing) {
            newListFollwing.add(prevItemFollowing);
        }
        for (int talentId : talentIds) {
            TalentEntity talentEntity = talentRepository.findById(talentId).orElse(null);
            if (talentEntity != null) {
//                System.out.println(userDTO.getFollowing());
                if (userDTO.getFollowing().contains(talentId)) {
                    throw new ApiRequestExeption("You were following " + talentEntity.getName());
                }
                newListFollwing.add(talentEntity);
            } else {
                throw new Exception("Talent doesn't exist");
            }
        }
        userEntity.setFollowing(newListFollwing);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.toDTO(userEntity);
        return userDTO;
    }

    public Object setUserUnfollow(RequestbodySetFollowing model) throws Exception {
        int userId = model.getUserId();
        List<Integer> talentIds = model.getTalentIds();
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        UserDTO userDTO = userConverter.toDTO(userEntity);
        List<TalentEntity> prevListFollowing = userEntity.getFollowing();
        ArrayList<TalentEntity> newListFollwing = new ArrayList<>();
        for(TalentEntity prevItemFollowing : prevListFollowing) {
            newListFollwing.add(prevItemFollowing);
        }
        for (Integer talentId : talentIds) {
            TalentEntity talentEntity = talentRepository.findById(talentId).orElse(null);
            if (talentEntity != null) {
                if (!userDTO.getFollowing().contains(talentId)) {
                    throw new Exception("You cannot unfollow " + talentEntity.getName());
                }
                newListFollwing.removeIf(talent -> talent.getId() == talentEntity.getId());
            } else {
                throw new Exception("Talent not found");
            }
        }
        userEntity.setFollowing(newListFollwing);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.toDTO(userEntity);
        return userDTO;
    }
}
