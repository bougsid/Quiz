package com.bougsid.services;

import com.bougsid.dao.QuizUserAssociationRepository;
import com.bougsid.dao.UserRepository;
import com.bougsid.entities.QuizUserAssociation;
import com.bougsid.entities.User;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private QuizUserAssociationRepository quizUserAssociationRepository;

    @GetMapping
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @GetMapping("/information")
    public List<QuizUserAssociation> getInformation(final HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        String username = claims.getSubject();
        System.out.println("Username =" + username);
        return this.quizUserAssociationRepository.findByUser(this.repository.findByUsername(username));
    }

    @PutMapping
    public List<User> saveAll(@RequestBody List<User> users) {
        System.out.println(users);
        return this.repository.save(users);
    }

    @PostMapping("/affect-quiz")
    public List<QuizUserAssociation> affectQuizToUsers(@RequestBody List<QuizUserAssociation> quizUserAssociations) {
        System.out.println(quizUserAssociations.get(0).getQuiz());
        System.out.println(quizUserAssociations.get(0).getQuizId());
        return this.quizUserAssociationRepository.save(quizUserAssociations);
    }
}
