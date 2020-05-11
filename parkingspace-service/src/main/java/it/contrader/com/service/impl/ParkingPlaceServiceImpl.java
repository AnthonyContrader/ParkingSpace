package it.contrader.com.service.impl;

import it.contrader.com.service.ParkingPlaceService;
import it.contrader.com.domain.ParkingPlace;
import it.contrader.com.repository.ParkingPlaceRepository;
import it.contrader.com.service.dto.ParkingPlaceDTO;
import it.contrader.com.service.mapper.ParkingPlaceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing ParkingPlace.
 */
@Service
@Transactional
public class ParkingPlaceServiceImpl implements ParkingPlaceService {

    private final Logger log = LoggerFactory.getLogger(ParkingPlaceServiceImpl.class);

    private final ParkingPlaceRepository parkingPlaceRepository;

    private final ParkingPlaceMapper parkingPlaceMapper;

    public ParkingPlaceServiceImpl(ParkingPlaceRepository parkingPlaceRepository, ParkingPlaceMapper parkingPlaceMapper) {
        this.parkingPlaceRepository = parkingPlaceRepository;
        this.parkingPlaceMapper = parkingPlaceMapper;
    }

    /**
     * Save a parkingPlace.
     *
     * @param parkingPlaceDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ParkingPlaceDTO save(ParkingPlaceDTO parkingPlaceDTO) {
        log.debug("Request to save ParkingPlace : {}", parkingPlaceDTO);
        ParkingPlace parkingPlace = parkingPlaceMapper.toEntity(parkingPlaceDTO);
        parkingPlace = parkingPlaceRepository.save(parkingPlace);
        return parkingPlaceMapper.toDto(parkingPlace);
    }

    /**
     * Get all the parkingPlaces.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ParkingPlaceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ParkingPlaces");
        return parkingPlaceRepository.findAll(pageable)
            .map(parkingPlaceMapper::toDto);
    }


    /**
     * Get one parkingPlace by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ParkingPlaceDTO> findOne(Long id) {
        log.debug("Request to get ParkingPlace : {}", id);
        return parkingPlaceRepository.findById(id)
            .map(parkingPlaceMapper::toDto);
    }

    /**
     * Delete the parkingPlace by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ParkingPlace : {}", id);
        parkingPlaceRepository.deleteById(id);
    }
}
