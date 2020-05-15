package it.contrader.com.repository;

import it.contrader.com.domain.AssigmentParking;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AssigmentParking entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AssigmentParkingRepository extends JpaRepository<AssigmentParking, Long> {

}
