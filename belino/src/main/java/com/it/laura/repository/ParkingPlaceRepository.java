package com.it.laura.repository;

import com.it.laura.domain.ParkingPlace;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ParkingPlace entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Long> {

}
