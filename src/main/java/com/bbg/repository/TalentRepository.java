package com.bbg.repository;

import com.bbg.entity.TalentEntity;
import com.bbg.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TalentRepository extends JpaRepository<TalentEntity, Integer> {

}
