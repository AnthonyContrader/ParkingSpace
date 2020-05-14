package com.it.contrader.service;

import com.it.contrader.service.dto.BillDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Bill.
 */
public interface BillService {

    /**
     * Save a bill.
     *
     * @param billDTO the entity to save
     * @return the persisted entity
     */
    BillDTO save(BillDTO billDTO);

    /**
     * Get all the bills.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<BillDTO> findAll(Pageable pageable);


    /**
     * Get the "id" bill.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BillDTO> findOne(Long id);

    /**
     * Delete the "id" bill.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
    
    
    //to let services communicate
    String getAvailableBills();//String jwt); //took the jwt, it will take back data and call the other service
    
}
