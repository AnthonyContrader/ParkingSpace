package it.contrader.com.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.com.service.AssignmentParkingService;
import it.contrader.com.web.rest.errors.BadRequestAlertException;
import it.contrader.com.web.rest.util.HeaderUtil;
import it.contrader.com.web.rest.util.PaginationUtil;
import it.contrader.com.service.dto.AssignmentParkingDTO;
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
 * REST controller for managing AssignmentParking.
 */
@RestController
@RequestMapping("/api")
public class AssignmentParkingResource {

    private final Logger log = LoggerFactory.getLogger(AssignmentParkingResource.class);

    private static final String ENTITY_NAME = "billAssignmentParking";

    private final AssignmentParkingService assignmentParkingService;

    public AssignmentParkingResource(AssignmentParkingService assignmentParkingService) {
        this.assignmentParkingService = assignmentParkingService;
    }

    /**
     * POST  /assignment-parkings : Create a new assignmentParking.
     *
     * @param assignmentParkingDTO the assignmentParkingDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new assignmentParkingDTO, or with status 400 (Bad Request) if the assignmentParking has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/assignment-parkings")
    @Timed
    public ResponseEntity<AssignmentParkingDTO> createAssignmentParking(@RequestBody AssignmentParkingDTO assignmentParkingDTO) throws URISyntaxException {
        log.debug("REST request to save AssignmentParking : {}", assignmentParkingDTO);
        if (assignmentParkingDTO.getId() != null) {
            throw new BadRequestAlertException("A new assignmentParking cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AssignmentParkingDTO result = assignmentParkingService.save(assignmentParkingDTO);
        return ResponseEntity.created(new URI("/api/assignment-parkings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /assignment-parkings : Updates an existing assignmentParking.
     *
     * @param assignmentParkingDTO the assignmentParkingDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated assignmentParkingDTO,
     * or with status 400 (Bad Request) if the assignmentParkingDTO is not valid,
     * or with status 500 (Internal Server Error) if the assignmentParkingDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/assignment-parkings")
    @Timed
    public ResponseEntity<AssignmentParkingDTO> updateAssignmentParking(@RequestBody AssignmentParkingDTO assignmentParkingDTO) throws URISyntaxException {
        log.debug("REST request to update AssignmentParking : {}", assignmentParkingDTO);
        if (assignmentParkingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AssignmentParkingDTO result = assignmentParkingService.save(assignmentParkingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, assignmentParkingDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /assignment-parkings : get all the assignmentParkings.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of assignmentParkings in body
     */
    @GetMapping("/assignment-parkings")
    @Timed
    public ResponseEntity<List<AssignmentParkingDTO>> getAllAssignmentParkings(Pageable pageable) {
        log.debug("REST request to get a page of AssignmentParkings");
        Page<AssignmentParkingDTO> page = assignmentParkingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/assignment-parkings");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /assignment-parkings/:id : get the "id" assignmentParking.
     *
     * @param id the id of the assignmentParkingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the assignmentParkingDTO, or with status 404 (Not Found)
     */
    @GetMapping("/assignment-parkings/{id}")
    @Timed
    public ResponseEntity<AssignmentParkingDTO> getAssignmentParking(@PathVariable Long id) {
        log.debug("REST request to get AssignmentParking : {}", id);
        Optional<AssignmentParkingDTO> assignmentParkingDTO = assignmentParkingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(assignmentParkingDTO);
    }

    /**
     * DELETE  /assignment-parkings/:id : delete the "id" assignmentParking.
     *
     * @param id the id of the assignmentParkingDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/assignment-parkings/{id}")
    @Timed
    public ResponseEntity<Void> deleteAssignmentParking(@PathVariable Long id) {
        log.debug("REST request to delete AssignmentParking : {}", id);
        assignmentParkingService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
