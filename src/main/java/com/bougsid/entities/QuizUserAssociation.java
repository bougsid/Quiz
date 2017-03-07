package com.bougsid.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "QUIZ_USERS")
@IdClass(QuizUserAssociationID.class)
@Component
@Scope("prototype")
public class QuizUserAssociation {
    @Id
    @Column(name = "quiz_id")
    private Long quizId;
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "score")
    private float score;
    @ManyToOne
    @JoinColumn(name = "QUIZ_ID", updatable = false, insertable = false)
    private Quiz quiz;
    @ManyToOne
    @JoinColumn(name = "USER_ID", updatable = false, insertable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private QuizTentative quizTentative;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    public QuizUserAssociation() {

    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
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

    public QuizTentative getQuizTentative() {
        return quizTentative;
    }

    public void setQuizTentative(QuizTentative quizTentative) {
        this.quizTentative = quizTentative;
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