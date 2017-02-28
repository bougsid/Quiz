package com.bougsid.dao;

import com.bougsid.entities.QuizUserAssociation;
import com.bougsid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by bougsid.ayoub on 2/28/2017.
 */
public interface QuizUserAssociationRepository extends JpaRepository<QuizUserAssociation, Long> {
    List<QuizUserAssociation> findByUser(User user);
}