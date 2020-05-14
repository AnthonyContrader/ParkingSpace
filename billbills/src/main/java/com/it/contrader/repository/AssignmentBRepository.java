package com.it.contrader.repository;

import com.it.contrader.domain.AssignmentB;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AssignmentB entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AssignmentBRepository extends JpaRepository<AssignmentB, Long> {

}
