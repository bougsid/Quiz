package com.bougsid.entities;

import java.io.Serializable;

/**
 * Created by Ayoub on 28/02/2017.
 */
public class QuizUserID implements Serializable {

    private Long quizId;

    private Long userId;

    public int hashCode() {
        return (int)(quizId + userId);
    }

    public boolean equals(Object object) {
        if (object instanceof QuizUserID) {
            QuizUserID otherId = (QuizUserID) object;
            return (otherId.quizId == this.quizId) && (otherId.userId == this.userId);
        }
        return false;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}