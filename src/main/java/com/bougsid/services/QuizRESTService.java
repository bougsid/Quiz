package com.bougsid.services;

import com.bougsid.dao.QuizRepository;
import com.bougsid.dao.UserRepository;
import com.bougsid.entities.Quiz;
import com.bougsid.entities.QuizUserAssociation;
import com.bougsid.metier.QuizMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bougsid.ayoub on 2/24/2017.
 */
@RestController
@RequestMapping("/api/quiz")
public class QuizRESTService {
    @Autowired
    private QuizRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizMetier metier;

    @GetMapping("/{page}/{size}")
    public Page<Quiz> getAll(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        return this.repository.findAll(new PageRequest(page, size));
    }

    @GetMapping("/{id}")
    public Quiz addQuiz(@PathVariable(name = "id") Long id) {
        return this.repository.findOne(id);
    }

    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        System.out.println(quiz.getDuration().toMinutes());
        return this.repository.save(quiz);
    }


    @PostMapping("/result")
    public QuizUserAssociation getResult(@RequestBody Quiz quiz) {
        return this.metier.getResult(quiz);
    }

//    @GetMapping("/quizzes")
//    public List<Quiz> getQuizzesOfLoggedUser(final HttpServletRequest request) {
//        Claims claims = (Claims) request.getAttribute("claims");
//        String username = claims.getSubject();
//        return this.quizUserAssociationRepository.findByUser(this.userRepository.findByUsername(username));
//    }
}
