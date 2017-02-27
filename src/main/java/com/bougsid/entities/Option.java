package com.bougsid.entities;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

/**
 * Created by bougsid.ayoub on 2/23/2017.
 */

@Entity
@Table(name = "options" )
@Scope("prototype")

public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean correct;
    private boolean answer;

    public Option() {
    }

    public Option(String content, boolean correct, Question question) {
        this.content = content;
        this.correct = correct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

}
