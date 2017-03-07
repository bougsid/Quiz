package com.bougsid.services;

import com.bougsid.dao.QuizUserAssociationRepository;
import com.bougsid.dao.UserRepository;
import com.bougsid.entities.QuizUserAssociation;
import com.bougsid.entities.User;
import com.bougsid.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bougsid.ayoub on 2/24/2017.
 */
@RestController
@RequestMapping("/api/user")

public class UserRESTService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMetier metier;
    @Autowired
    private QuizUserAssociationRepository quizUserAssociationRepository;

    @GetMapping
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @PutMapping
    public List<User> saveAll(@RequestBody List<User> users) {

        return this.repository.save(users);
    }

    @GetMapping("/scoreboard/{id}")
    List<QuizUserAssociation> getUsersOfQuiz(@PathVariable(name = "id") Long quizId) {
        return this.metier.getUsersOfQuiz(quizId);
    }

    @PostMapping("/affect-quiz")
    public List<QuizUserAssociation> affectQuizToUsers(@RequestBody List<QuizUserAssociation> quizUserAssociations) {
        return this.quizUserAssociationRepository.save(quizUserAssociations);
    }
}
