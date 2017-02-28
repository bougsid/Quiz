package com.bougsid.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "QUIZ_USERS")
@Component
@Scope("prototype")
public class QuizUserAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "MARK")
    private float mark;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "QUIZ_ID", referencedColumnName = "ID")
    private Quiz quiz;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
    public QuizUserAssociation() {
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}