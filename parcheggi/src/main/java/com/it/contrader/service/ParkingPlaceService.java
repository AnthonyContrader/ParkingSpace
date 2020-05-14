package com.it.contrader.service;

import com.it.contrader.service.dto.ParkingPlaceDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing ParkingPlace.
 */
public interface ParkingPlaceService {

    /**
     * Save a parkingPlace.
     *
     * @param parkingPlaceDTO the entity to save
     * @return the persisted entity
     */
    ParkingPlaceDTO save(ParkingPlaceDTO parkingPlaceDTO);

    /**
     * Get all the parkingPlaces.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ParkingPlaceDTO> findAll(Pageable pageable);


    /**
     * Get the "id" parkingPlace.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ParkingPlaceDTO> findOne(Long id);

    /**
     * Delete the "id" parkingPlace.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
