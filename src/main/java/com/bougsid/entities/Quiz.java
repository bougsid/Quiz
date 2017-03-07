package com.bougsid.entities;

import com.bougsid.entities.deserializer.DurationDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

/**
 * Created by bougsid.ayoub on 2/23/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Scope("prototype")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Question> questions;
    @JsonDeserialize(using = DurationDeserializer.class)
    private Duration duration;
    @JsonIgnore
    @OneToMany(mappedBy = "quiz")
    private List<QuizUserAssociation> users;

    public Quiz() {
    }

    public Quiz(String title, List<Question> questions, Duration duration) {
        this.title = title;
        this.questions = questions;
        this.duration = duration;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
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

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                ", duration=" + duration +
                ", users=" + users +
                '}';
    }
}
