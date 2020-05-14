package com.it.contrader.service;

import com.it.contrader.service.dto.AssignmentBDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing AssignmentB.
 */
public interface AssignmentBService {

    /**
     * Save a assignmentB.
     *
     * @param assignmentBDTO the entity to save
     * @return the persisted entity
     */
    AssignmentBDTO save(AssignmentBDTO assignmentBDTO);

    /**
     * Get all the assignmentBS.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<AssignmentBDTO> findAll(Pageable pageable);


    /**
     * Get the "id" assignmentB.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AssignmentBDTO> findOne(Long id);

    /**
     * Delete the "id" assignmentB.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
