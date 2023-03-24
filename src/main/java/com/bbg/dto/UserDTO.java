package com.bbg.dto;

import com.bbg.entity.UserEntity;

import java.util.ArrayList;

public class UserDTO {
    private int id;
    private String name;
    private int age;
    private ArrayList<Integer> following;

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

    public ArrayList<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<Integer> following) {
        this.following = following;
    }
}
