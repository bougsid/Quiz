package com.bougsid.dao;

import com.bougsid.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by bougsid.ayoub on 2/23/2017.
 */
@RepositoryRestResource
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
