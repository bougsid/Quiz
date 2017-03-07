package com.bougsid.services;

import com.bougsid.dao.QuizRepository;
import com.bougsid.entities.Quiz;
import com.bougsid.entities.QuizTentative;
import com.bougsid.entities.QuizUserAssociation;
import com.bougsid.metier.QuizMetier;
import com.bougsid.util.LoggedUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bougsid.ayoub on 2/24/2017.
 */
@RestController
@RequestMapping("/api/quiz")
public class QuizRESTService {
    @Autowired
    private LoggedUserUtil loggedUserUtil;
    @Autowired
    private QuizRepository repository;
    @Autowired
    private QuizMetier metier;

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizOfUser(final HttpServletRequest request, @PathVariable(name = "id") Long quizId) {
        Quiz quiz = this.metier.getQuizOfUser(this.loggedUserUtil.getUser(request), quizId);
        if (quiz != null) {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz) {
        return this.repository.save(quiz);
    }

    @GetMapping("/{page}/{size}")
    public Page<Quiz> getAll(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        return this.repository.findAll(new PageRequest(page, size));
    }

    @PostMapping("/result")
    public QuizUserAssociation correctQuiz(final HttpServletRequest request, @RequestBody QuizTentative quizTentative) {
        System.out.println(quizTentative);
        return this.metier.correctQuizAndSaveResultForUser(quizTentative, this.loggedUserUtil.getUser(request));
    }

    @GetMapping("/user-quizzes")
    public Page<QuizUserAssociation> getQuizzesOfUser(final HttpServletRequest request,
                                                      @RequestParam(name = "page") int page,
                                                      @RequestParam(name = "size") int size) {
        return this.metier.getQuizzesOfUser(
                this.loggedUserUtil.getUser(request),
                new PageRequest(page, size));
    }

}
