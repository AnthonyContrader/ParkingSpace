package com.it.contrader.service.impl;

import com.it.contrader.service.AssigmentParkingService;
import com.it.contrader.domain.AssigmentParking;
import com.it.contrader.repository.AssigmentParkingRepository;
import com.it.contrader.service.dto.AssigmentParkingDTO;
import com.it.contrader.service.mapper.AssigmentParkingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing AssigmentParking.
 */
@Service
@Transactional
public class AssigmentParkingServiceImpl implements AssigmentParkingService {

    private final Logger log = LoggerFactory.getLogger(AssigmentParkingServiceImpl.class);

    private final AssigmentParkingRepository assigmentParkingRepository;

    private final AssigmentParkingMapper assigmentParkingMapper;

    public AssigmentParkingServiceImpl(AssigmentParkingRepository assigmentParkingRepository, AssigmentParkingMapper assigmentParkingMapper) {
        this.assigmentParkingRepository = assigmentParkingRepository;
        this.assigmentParkingMapper = assigmentParkingMapper;
    }

    /**
     * Save a assigmentParking.
     *
     * @param assigmentParkingDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AssigmentParkingDTO save(AssigmentParkingDTO assigmentParkingDTO) {
        log.debug("Request to save AssigmentParking : {}", assigmentParkingDTO);
        AssigmentParking assigmentParking = assigmentParkingMapper.toEntity(assigmentParkingDTO);
        assigmentParking = assigmentParkingRepository.save(assigmentParking);
        return assigmentParkingMapper.toDto(assigmentParking);
    }

    /**
     * Get all the assigmentParkings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AssigmentParkingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AssigmentParkings");
        return assigmentParkingRepository.findAll(pageable)
            .map(assigmentParkingMapper::toDto);
    }


    /**
     * Get one assigmentParking by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AssigmentParkingDTO> findOne(Long id) {
        log.debug("Request to get AssigmentParking : {}", id);
        return assigmentParkingRepository.findById(id)
            .map(assigmentParkingMapper::toDto);
    }

    /**
     * Delete the assigmentParking by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AssigmentParking : {}", id);
        assigmentParkingRepository.deleteById(id);
    }
}
