package com.bougsid.services;

import com.bougsid.dao.QuestionRepository;
import com.bougsid.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bougsid.ayoub on 2/24/2017.
 */
@RestController
@RequestMapping("/api/question")

public class QuestionRESTService {
    @Autowired
    private QuestionRepository repository;

    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return this.repository.save(question);
    }
}
