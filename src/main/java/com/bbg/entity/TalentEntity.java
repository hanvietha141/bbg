package com.bbg.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="talent")
public class TalentEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String name;

    @ManyToMany(mappedBy = "following")
    private List<UserEntity> followedBy;

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

    public List<UserEntity> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(List<UserEntity> followedBy) {
        this.followedBy = followedBy;
    }
}
