package com.bougsid.metier;

import com.bougsid.dao.QuizRepository;
import com.bougsid.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by bougsid.ayoub on 2/24/2017.
 */
@Service
public class QuizMetier {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private QuizRepository repository;

    public QuizUserAssociation getResult(Quiz quiz) {
        float mark = correctQuizAndGetMark(quiz);
        User user = new User();//TO REMOVE
        QuizUserAssociation quizUserAssociation = context.getBean(QuizUserAssociation.class);
        quizUserAssociation.setUser(user);
        quizUserAssociation.setQuiz(quiz);
        quizUserAssociation.setMark(mark);
        return quizUserAssociation;
    }

    private float correctQuizAndGetMark(Quiz quiz) {
        float mark = 0;
        for (Question question : quiz.getQuestions()) {
            if (questionCorrect(question)) mark++;
        }
        return mark;
    }

    private boolean questionCorrect(Question question) {
        boolean correct = true;
        for (Option option : question.getOptions()) {
            if (optionNotCorrect(option)) {
                correct = false;
                break;
            }
        }
        return correct;
    }

    private boolean optionNotCorrect(Option option) {
        return (option.isAnswer() != option.isCorrect());
    }

}
