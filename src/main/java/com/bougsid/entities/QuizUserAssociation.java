package com.bougsid.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "QUIZ_USERS")
@IdClass(QuizUserID.class)
@Component
@Scope("prototype")
public class QuizUserAssociation {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "quiz_id")
    private Long quizId;
    @Id
    @Column(name = "user_id")
    private Long userId;
//    private Long id;
    @Column(name = "MARK")
    private float mark;
    @ManyToOne
    @JoinColumn(name = "QUIZ_ID", updatable = false, insertable = false)
    private Quiz quiz;
    @ManyToOne
    @JoinColumn(name = "USER_ID", updatable = false, insertable = false)
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