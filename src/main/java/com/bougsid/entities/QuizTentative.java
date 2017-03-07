package com.bougsid.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.Entity;

/**
 * Created by bougsid.ayoub on 3/7/2017.
 */
@Scope("prototype")
@Entity
public class QuizTentative extends Quiz {
    private float score;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return super.toString()+"Score ="+score;
    }
}
