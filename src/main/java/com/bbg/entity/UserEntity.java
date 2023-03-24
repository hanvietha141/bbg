package com.bbg.entity;


import com.bbg.dto.TalentDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column
    private String name;
    @Column
    private int age;

    @ManyToMany()
    @JoinTable(name = "talent_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "talent_id")
    )
    private List<TalentEntity> following;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<TalentEntity> getFollowing() {
        return following;
    }

    public void setFollowing(List<TalentEntity> following) {
        this.following = following;
    }
}
