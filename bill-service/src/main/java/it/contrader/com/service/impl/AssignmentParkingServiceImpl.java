package it.contrader.com.service.impl;

import it.contrader.com.service.AssignmentParkingService;
import it.contrader.com.domain.AssignmentParking;
import it.contrader.com.repository.AssignmentParkingRepository;
import it.contrader.com.service.dto.AssignmentParkingDTO;
import it.contrader.com.service.mapper.AssignmentParkingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing AssignmentParking.
 */
@Service
@Transactional
public class AssignmentParkingServiceImpl implements AssignmentParkingService {

    private final Logger log = LoggerFactory.getLogger(AssignmentParkingServiceImpl.class);

    private final AssignmentParkingRepository assignmentParkingRepository;

    private final AssignmentParkingMapper assignmentParkingMapper;

    public AssignmentParkingServiceImpl(AssignmentParkingRepository assignmentParkingRepository, AssignmentParkingMapper assignmentParkingMapper) {
        this.assignmentParkingRepository = assignmentParkingRepository;
        this.assignmentParkingMapper = assignmentParkingMapper;
    }

    /**
     * Save a assignmentParking.
     *
     * @param assignmentParkingDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AssignmentParkingDTO save(AssignmentParkingDTO assignmentParkingDTO) {
        log.debug("Request to save AssignmentParking : {}", assignmentParkingDTO);
        AssignmentParking assignmentParking = assignmentParkingMapper.toEntity(assignmentParkingDTO);
        assignmentParking = assignmentParkingRepository.save(assignmentParking);
        return assignmentParkingMapper.toDto(assignmentParking);
    }

    /**
     * Get all the assignmentParkings.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AssignmentParkingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AssignmentParkings");
        return assignmentParkingRepository.findAll(pageable)
            .map(assignmentParkingMapper::toDto);
    }


    /**
     * Get one assignmentParking by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AssignmentParkingDTO> findOne(Long id) {
        log.debug("Request to get AssignmentParking : {}", id);
        return assignmentParkingRepository.findById(id)
            .map(assignmentParkingMapper::toDto);
    }

    /**
     * Delete the assignmentParking by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AssignmentParking : {}", id);
        assignmentParkingRepository.deleteById(id);
    }
}
