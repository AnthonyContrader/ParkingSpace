package it.contrader.com.service;

import it.contrader.com.service.dto.AssignmentParkingDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing AssignmentParking.
 */
public interface AssignmentParkingService {

    /**
     * Save a assignmentParking.
     *
     * @param assignmentParkingDTO the entity to save
     * @return the persisted entity
     */
    AssignmentParkingDTO save(AssignmentParkingDTO assignmentParkingDTO);

    /**
     * Get all the assignmentParkings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<AssignmentParkingDTO> findAll(Pageable pageable);


    /**
     * Get the "id" assignmentParking.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AssignmentParkingDTO> findOne(Long id);

    /**
     * Delete the "id" assignmentParking.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
