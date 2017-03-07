package com.bougsid.metier;

import com.bougsid.dao.QuizRepository;
import com.bougsid.dao.QuizUserAssociationRepository;
import com.bougsid.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Autowired
    private QuizUserAssociationRepository quizUserAssociationRepository;

    public Quiz getQuizOfUser(User user, Long quizId) {
        Quiz quiz = this.repository.findOne(quizId);
        if (this.userHasThisQuizActive(user, quiz))
            return quiz;
        else
            return null;
    }

    private boolean userHasThisQuizActive(User user, Quiz quiz) {
        QuizUserAssociation quizUserAssociation = this.quizUserAssociationRepository
                .findByUserAndQuiz(user, quiz);
        return quizUserAssociation != null && quizUserAssociation.isActive();
    }

    public Page<QuizUserAssociation> getQuizzesOfUser(User user, Pageable pageable) {
        return this.quizUserAssociationRepository.findByUser(user, pageable);
    }

    public QuizUserAssociation correctQuizAndSaveResultForUser(QuizTentative quizTentative, User user) {
        this.correctQuizAndSetScore(quizTentative);
        return this.saveScoreForUser(quizTentative, user);
    }

    private void correctQuizAndSetScore(QuizTentative quizTentative) {
        float score = 0;
        for (Question question : quizTentative.getQuestions()) {
            if (questionCorrect(question)) score++;
        }
        quizTentative.setScore(score);
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

    private QuizUserAssociation saveScoreForUser(QuizTentative quizTentative, User user) {
        QuizUserAssociation quizUserAssociation = this.quizUserAssociationRepository
                .findByUserAndQuiz(user, quizTentative);
        quizTentative.setId(null);
        this.deleteQuizTentativeIfExist(quizUserAssociation);
        quizUserAssociation.setQuizTentative(quizTentative);
        quizUserAssociation.setActive(false);
        this.updateScoreWithMaximum(quizUserAssociation, quizTentative);
        return this.quizUserAssociationRepository.save(quizUserAssociation);
    }

    private void deleteQuizTentativeIfExist(QuizUserAssociation quizUserAssociation) {
        if (quizUserAssociation.getQuizTentative() != null)
            this.repository.delete(quizUserAssociation.getQuizTentative());
    }

    private void updateScoreWithMaximum(QuizUserAssociation quizUserAssociation, QuizTentative quizTentative) {
        quizUserAssociation.setScore(
                quizUserAssociation.getScore() >= quizTentative.getScore() ?
                        quizUserAssociation.getScore()
                        : quizTentative.getScore());
    }
}
