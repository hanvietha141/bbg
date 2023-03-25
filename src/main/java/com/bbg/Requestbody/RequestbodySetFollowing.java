package com.bbg.Requestbody;

import java.util.List;

public class RequestbodySetFollowing {
    private int userId;
    private List<Integer> talentIds;

    public RequestbodySetFollowing(int userId, List<Integer> talentIds) {
        this.userId = userId;
        this.talentIds = talentIds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getTalentIds() {
        return talentIds;
    }

    public void setTalentIds(List<Integer> talentIds) {
        this.talentIds = talentIds;
    }
}
