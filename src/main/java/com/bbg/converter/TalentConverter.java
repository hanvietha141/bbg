package com.bbg.converter;

import com.bbg.dto.TalentDTO;
import com.bbg.entity.TalentEntity;
import com.bbg.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TalentConverter {
    public TalentEntity toEntity (TalentDTO talentDTO) {
        TalentEntity talentEntity = new TalentEntity();
        talentEntity.setId(talentDTO.getId());
        talentEntity.setName(talentDTO.getName());
        return talentEntity;
    }

    public TalentDTO toDTO (TalentEntity talentEntity) {
        TalentDTO talentDTO = new TalentDTO();
        talentDTO.setId(talentEntity.getId());
        talentDTO.setName(talentEntity.getName());
        List<UserEntity> listFollowedBy = talentEntity.getFollowedBy();
        ArrayList<Integer> listIdFollowedBy = new ArrayList<>();
        for(UserEntity followBy: listFollowedBy) {
            listIdFollowedBy.add(followBy.getId());
        }
        talentDTO.setFollowBy(listIdFollowedBy);
        return talentDTO;
    }
}
