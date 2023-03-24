package com.bbg.converter;

import com.bbg.dto.TalentDTO;
import com.bbg.entity.TalentEntity;
import org.springframework.stereotype.Component;

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
        return talentDTO;
    }
}
