package com.bougsid.dao;

import com.bougsid.entities.QuizUserAssociation;
import com.bougsid.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bougsid.ayoub on 2/28/2017.
 */
public interface QuizUserAssociationRepository extends JpaRepository<QuizUserAssociation, Long> {
    Page<QuizUserAssociation> findByUser(User user, Pageable pageable);
}
