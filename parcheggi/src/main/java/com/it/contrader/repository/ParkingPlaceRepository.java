package com.it.contrader.repository;

import com.it.contrader.domain.ParkingPlace;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ParkingPlace entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Long> {

}
