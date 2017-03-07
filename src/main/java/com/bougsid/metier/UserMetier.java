package com.bougsid.metier;

import com.bougsid.dao.QuizRepository;
import com.bougsid.dao.QuizUserAssociationRepository;
import com.bougsid.dao.UserRepository;
import com.bougsid.entities.Quiz;
import com.bougsid.entities.QuizUserAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bougsid.ayoub on 3/6/2017.
 */
@Service
public class UserMetier {
    @Autowired
    private UserRepository repository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizUserAssociationRepository quizUserAssociationRepository;

    public List<QuizUserAssociation> getUsersOfQuiz(Long quizId) {
        Quiz quiz = this.quizRepository.findOne(quizId);
        return this.quizUserAssociationRepository.findByQuiz(quiz);
    }
}
