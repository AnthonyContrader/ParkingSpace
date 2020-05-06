package com.it.laura.service.impl;

import com.it.laura.service.FloorService;
import com.it.laura.domain.Floor;
import com.it.laura.repository.FloorRepository;
import com.it.laura.service.dto.FloorDTO;
import com.it.laura.service.mapper.FloorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Floor.
 */
@Service
@Transactional
public class FloorServiceImpl implements FloorService {

    private final Logger log = LoggerFactory.getLogger(FloorServiceImpl.class);

    private final FloorRepository floorRepository;

    private final FloorMapper floorMapper;

    public FloorServiceImpl(FloorRepository floorRepository, FloorMapper floorMapper) {
        this.floorRepository = floorRepository;
        this.floorMapper = floorMapper;
    }

    /**
     * Save a floor.
     *
     * @param floorDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FloorDTO save(FloorDTO floorDTO) {
        log.debug("Request to save Floor : {}", floorDTO);
        Floor floor = floorMapper.toEntity(floorDTO);
        floor = floorRepository.save(floor);
        return floorMapper.toDto(floor);
    }

    /**
     * Get all the floors.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<FloorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Floors");
        return floorRepository.findAll(pageable)
            .map(floorMapper::toDto);
    }


    /**
     * Get one floor by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FloorDTO> findOne(Long id) {
        log.debug("Request to get Floor : {}", id);
        return floorRepository.findById(id)
            .map(floorMapper::toDto);
    }

    /**
     * Delete the floor by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Floor : {}", id);
        floorRepository.deleteById(id);
    }
}
