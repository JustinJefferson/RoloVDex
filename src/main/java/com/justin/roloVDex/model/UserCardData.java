package com.justin.roloVDex.model;

import javax.persistence.Entity;


public class UserCardData {

    private Long userId;
    private Long cardDataId;

    public UserCardData() {}

    public UserCardData(Long userId, Long cardDataId) {
        this.userId = userId;
        this.cardDataId = cardDataId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCardDataId() {
        return cardDataId;
    }

    public void setCardDataId(Long cardDataId) {
        this.cardDataId = cardDataId;
    }
}
