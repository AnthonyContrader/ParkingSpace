package it.contrader.com.repository;

import it.contrader.com.domain.AssignmentParking;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AssignmentParking entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AssignmentParkingRepository extends JpaRepository<AssignmentParking, Long> {

}
