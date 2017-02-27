package com.bougsid.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "QUIZ_USERS")
@Component
@Scope("prototype")
public class QuizUserAssociation {
    //    @Id
//    private long employeeId;
//    @Id
//    private long projectId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MARK")
    private float mark;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "QUIZ_ID", referencedColumnName = "ID")
  /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(username = "employeeId", updatable = false, insertable = false)
  * or @JoinColumn(username = "employeeId", updatable = false, insertable = false, referencedColumnName = "id")
  */
    private Quiz quiz;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "USER_ID", referencedColumnName = "ID")
  /* the same goes here:
  *  if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(username = "projectId", updatable = false, insertable = false)
  * or @JoinColumn(username = "projectId", updatable = false, insertable = false, referencedColumnName = "id")
  */
    private User user;

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
}