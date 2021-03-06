package com.bougsid.dao;

import com.bougsid.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by bougsid.ayoub on 2/23/2017.
 */
@RepositoryRestResource
public interface AnswerRepository extends JpaRepository<Option, Long> {
}
