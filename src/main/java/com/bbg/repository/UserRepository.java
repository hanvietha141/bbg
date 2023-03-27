package com.bbg.repository;

import com.bbg.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value = "SELECT * FROM user WHERE id > 3", nativeQuery = true)
    Page<UserEntity> findByIdGreaterThan3(PageRequest pageRequest);
}
