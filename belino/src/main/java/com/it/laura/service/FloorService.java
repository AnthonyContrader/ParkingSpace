package com.it.laura.service;

import com.it.laura.service.dto.FloorDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Floor.
 */
public interface FloorService {

    /**
     * Save a floor.
     *
     * @param floorDTO the entity to save
     * @return the persisted entity
     */
    FloorDTO save(FloorDTO floorDTO);

    /**
     * Get all the floors.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<FloorDTO> findAll(Pageable pageable);


    /**
     * Get the "id" floor.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<FloorDTO> findOne(Long id);

    /**
     * Delete the "id" floor.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
