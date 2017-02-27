package com.bougsid.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

/**
 * Created by bougsid.ayoub on 2/23/2017.
 */
@Entity
@Scope("prototype")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @JsonIgnore
    private Duration timeBox;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Question> questions;
//
//    @ManyToMany
//    private List<User> users;


    @JsonIgnore
    @OneToMany(mappedBy="quiz")
    private List<QuizUserAssociation> users;

    public Quiz() {
    }

    public Quiz(String title, List<Question> questions,Duration timeBox) {
        this.title = title;
        this.questions = questions;
        this.timeBox = timeBox;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getTimeBox() {
        return timeBox;
    }

    public void setTimeBox(Duration timeBox) {
        this.timeBox = timeBox;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<QuizUserAssociation> getUsers() {
        return users;
    }

    public void setUsers(List<QuizUserAssociation> users) {
        this.users = users;
    }
}
