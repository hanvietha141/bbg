package com.bbg.service.impl;

import com.bbg.converter.TalentConverter;
import com.bbg.dto.TalentDTO;
import com.bbg.dto.UserDTO;
import com.bbg.entity.TalentEntity;
import com.bbg.entity.UserEntity;
import com.bbg.repository.TalentRepository;
import com.bbg.repository.UserRepository;
import com.bbg.service.ITalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TalentService implements ITalentService {
    @Autowired
    private TalentRepository talentRepository;
    @Autowired
    private TalentConverter talentConverter;
    @Override
    public ArrayList<TalentDTO> getTalent() {
        ArrayList<TalentEntity> talentEntities = (ArrayList<TalentEntity>) talentRepository.findAll();
        ArrayList<TalentDTO> talentDTOList = new ArrayList<TalentDTO>();
        for (TalentEntity talentEntity : talentEntities) {
            TalentDTO talentDTO = talentConverter.toDTO(talentEntity);
            talentDTOList.add(talentDTO);
            System.out.println(talentDTO);
        }
        return talentDTOList;
    }
}
