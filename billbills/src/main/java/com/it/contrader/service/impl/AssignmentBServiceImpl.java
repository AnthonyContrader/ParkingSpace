package com.it.contrader.service.impl;

import com.it.contrader.service.AssignmentBService;
import com.it.contrader.domain.AssignmentB;
import com.it.contrader.repository.AssignmentBRepository;
import com.it.contrader.service.dto.AssignmentBDTO;
import com.it.contrader.service.mapper.AssignmentBMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing AssignmentB.
 */
@Service
@Transactional
public class AssignmentBServiceImpl implements AssignmentBService {

    private final Logger log = LoggerFactory.getLogger(AssignmentBServiceImpl.class);

    private final AssignmentBRepository assignmentBRepository;

    private final AssignmentBMapper assignmentBMapper;

    public AssignmentBServiceImpl(AssignmentBRepository assignmentBRepository, AssignmentBMapper assignmentBMapper) {
        this.assignmentBRepository = assignmentBRepository;
        this.assignmentBMapper = assignmentBMapper;
    }

    /**
     * Save a assignmentB.
     *
     * @param assignmentBDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AssignmentBDTO save(AssignmentBDTO assignmentBDTO) {
        log.debug("Request to save AssignmentB : {}", assignmentBDTO);
        AssignmentB assignmentB = assignmentBMapper.toEntity(assignmentBDTO);
        assignmentB = assignmentBRepository.save(assignmentB);
        return assignmentBMapper.toDto(assignmentB);
    }

    /**
     * Get all the assignmentBS.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AssignmentBDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AssignmentBS");
        return assignmentBRepository.findAll(pageable)
            .map(assignmentBMapper::toDto);
    }


    /**
     * Get one assignmentB by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AssignmentBDTO> findOne(Long id) {
        log.debug("Request to get AssignmentB : {}", id);
        return assignmentBRepository.findById(id)
            .map(assignmentBMapper::toDto);
    }

    /**
     * Delete the assignmentB by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AssignmentB : {}", id);
        assignmentBRepository.deleteById(id);
    }
}
