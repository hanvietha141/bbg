package com.bbg.dto;

import java.util.ArrayList;

public class TalentDTO {
    private int id;
    private String name;

    private ArrayList<Integer> followBy;

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

    public ArrayList<Integer> getFollowBy() {
        return followBy;
    }

    public void setFollowBy(ArrayList<Integer> followBy) {
        this.followBy = followBy;
    }
}
