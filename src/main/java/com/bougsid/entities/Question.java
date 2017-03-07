package com.bougsid.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bougsid.ayoub on 2/23/2017.
 */
@Entity
@Scope("prototype")

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

//    @ManyToMany
//    private List<Quiz> quizzes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Option> options;

    public Question() {
    }

    public Question(String content, List<Option> options) {
        this.content = content;
        this.options = options;
    }

    @JsonIgnore
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
//
//    public List<Quiz> getQuizzes() {
//        return quizzes;
//    }
//
//    public void setQuizzes(List<Quiz> quizzes) {
//        this.quizzes = quizzes;
//    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
