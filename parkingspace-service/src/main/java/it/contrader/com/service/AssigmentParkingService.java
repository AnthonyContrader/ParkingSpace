package it.contrader.com.service;

import it.contrader.com.service.dto.AssigmentParkingDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing AssigmentParking.
 */
public interface AssigmentParkingService {

    /**
     * Save a assigmentParking.
     *
     * @param assigmentParkingDTO the entity to save
     * @return the persisted entity
     */
    AssigmentParkingDTO save(AssigmentParkingDTO assigmentParkingDTO);

    /**
     * Get all the assigmentParkings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<AssigmentParkingDTO> findAll(Pageable pageable);


    /**
     * Get the "id" assigmentParking.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AssigmentParkingDTO> findOne(Long id);

    /**
     * Delete the "id" assigmentParking.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
