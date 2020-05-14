package com.it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.it.contrader.service.AssignmentBService;
import com.it.contrader.web.rest.errors.BadRequestAlertException;
import com.it.contrader.web.rest.util.HeaderUtil;
import com.it.contrader.web.rest.util.PaginationUtil;
import com.it.contrader.service.dto.AssignmentBDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing AssignmentB.
 */
@RestController
@RequestMapping("/api")
public class AssignmentBResource {

    private final Logger log = LoggerFactory.getLogger(AssignmentBResource.class);

    private static final String ENTITY_NAME = "billbillAssignmentB";

    private final AssignmentBService assignmentBService;

    public AssignmentBResource(AssignmentBService assignmentBService) {
        this.assignmentBService = assignmentBService;
    }

    /**
     * POST  /assignment-bs : Create a new assignmentB.
     *
     * @param assignmentBDTO the assignmentBDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new assignmentBDTO, or with status 400 (Bad Request) if the assignmentB has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/assignment-bs")
    @Timed
    public ResponseEntity<AssignmentBDTO> createAssignmentB(@RequestBody AssignmentBDTO assignmentBDTO) throws URISyntaxException {
        log.debug("REST request to save AssignmentB : {}", assignmentBDTO);
        if (assignmentBDTO.getId() != null) {
            throw new BadRequestAlertException("A new assignmentB cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AssignmentBDTO result = assignmentBService.save(assignmentBDTO);
        return ResponseEntity.created(new URI("/api/assignment-bs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /assignment-bs : Updates an existing assignmentB.
     *
     * @param assignmentBDTO the assignmentBDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated assignmentBDTO,
     * or with status 400 (Bad Request) if the assignmentBDTO is not valid,
     * or with status 500 (Internal Server Error) if the assignmentBDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/assignment-bs")
    @Timed
    public ResponseEntity<AssignmentBDTO> updateAssignmentB(@RequestBody AssignmentBDTO assignmentBDTO) throws URISyntaxException {
        log.debug("REST request to update AssignmentB : {}", assignmentBDTO);
        if (assignmentBDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AssignmentBDTO result = assignmentBService.save(assignmentBDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, assignmentBDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /assignment-bs : get all the assignmentBS.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of assignmentBS in body
     */
    @GetMapping("/assignment-bs")
    @Timed
    public ResponseEntity<List<AssignmentBDTO>> getAllAssignmentBS(Pageable pageable) {
        log.debug("REST request to get a page of AssignmentBS");
        Page<AssignmentBDTO> page = assignmentBService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/assignment-bs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /assignment-bs/:id : get the "id" assignmentB.
     *
     * @param id the id of the assignmentBDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the assignmentBDTO, or with status 404 (Not Found)
     */
    @GetMapping("/assignment-bs/{id}")
    @Timed
    public ResponseEntity<AssignmentBDTO> getAssignmentB(@PathVariable Long id) {
        log.debug("REST request to get AssignmentB : {}", id);
        Optional<AssignmentBDTO> assignmentBDTO = assignmentBService.findOne(id);
        return ResponseUtil.wrapOrNotFound(assignmentBDTO);
    }

    /**
     * DELETE  /assignment-bs/:id : delete the "id" assignmentB.
     *
     * @param id the id of the assignmentBDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/assignment-bs/{id}")
    @Timed
    public ResponseEntity<Void> deleteAssignmentB(@PathVariable Long id) {
        log.debug("REST request to delete AssignmentB : {}", id);
        assignmentBService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
