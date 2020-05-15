package it.contrader.com.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.com.service.AssigmentParkingService;
import it.contrader.com.web.rest.errors.BadRequestAlertException;
import it.contrader.com.web.rest.util.HeaderUtil;
import it.contrader.com.web.rest.util.PaginationUtil;
import it.contrader.com.service.dto.AssigmentParkingDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing AssigmentParking.
 */
@RestController
@RequestMapping("/api")
public class AssigmentParkingResource {

    private final Logger log = LoggerFactory.getLogger(AssigmentParkingResource.class);

    private static final String ENTITY_NAME = "parkingspaceAssigmentParking";

    private final AssigmentParkingService assigmentParkingService;

    public AssigmentParkingResource(AssigmentParkingService assigmentParkingService) {
        this.assigmentParkingService = assigmentParkingService;
    }

    /**
     * POST  /assigment-parkings : Create a new assigmentParking.
     *
     * @param assigmentParkingDTO the assigmentParkingDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new assigmentParkingDTO, or with status 400 (Bad Request) if the assigmentParking has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/assigment-parkings")
    @Timed
    public ResponseEntity<AssigmentParkingDTO> createAssigmentParking(@RequestBody AssigmentParkingDTO assigmentParkingDTO) throws URISyntaxException {
        log.debug("REST request to save AssigmentParking : {}", assigmentParkingDTO);
        if (assigmentParkingDTO.getId() != null) {
            throw new BadRequestAlertException("A new assigmentParking cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AssigmentParkingDTO result = assigmentParkingService.save(assigmentParkingDTO);
        return ResponseEntity.created(new URI("/api/assigment-parkings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /assigment-parkings : Updates an existing assigmentParking.
     *
     * @param assigmentParkingDTO the assigmentParkingDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated assigmentParkingDTO,
     * or with status 400 (Bad Request) if the assigmentParkingDTO is not valid,
     * or with status 500 (Internal Server Error) if the assigmentParkingDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/assigment-parkings")
    @Timed
    public ResponseEntity<AssigmentParkingDTO> updateAssigmentParking(@RequestBody AssigmentParkingDTO assigmentParkingDTO) throws URISyntaxException {
        log.debug("REST request to update AssigmentParking : {}", assigmentParkingDTO);
        if (assigmentParkingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AssigmentParkingDTO result = assigmentParkingService.save(assigmentParkingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, assigmentParkingDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /assigment-parkings : get all the assigmentParkings.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of assigmentParkings in body
     */
    @GetMapping("/assigment-parkings")
    @Timed
    public ResponseEntity<List<AssigmentParkingDTO>> getAllAssigmentParkings(Pageable pageable) {
        log.debug("REST request to get a page of AssigmentParkings");
        Page<AssigmentParkingDTO> page = assigmentParkingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/assigment-parkings");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
    @SuppressWarnings("unchecked")
	@GetMapping("/assigmentForBillService")
    @Timed
    public ResponseEntity<AssigmentParkingDTO> getAll(){
		/*
		 * //Optional<AssigmentParkingDTO> list = Optional.empty(); //list =
		 * (Optional<AssigmentParkingDTO>) assigmentParkingService.findOne((long) 1);
		 * Optional<AssigmentParkingDTO> ass = assigmentParkingService.findOne((long)
		 * 1); AssigmentParkingDTO assignment = ass.get(); AssigmentParkingDTO apd = new
		 * AssigmentParkingDTO(); apd.setId(assignment.getId());
		 * apd.setCarId(assignment.getCarId());
		 * apd.setParkingplaceId(assignment.getParkingplaceId());
		 * apd.setEntryDateTime(assignment.getEntryDateTime());
		 * 
		 * System.out.println("Stampa:    ......................"+apd.toString());
		 * return apd;
		 */
    	AssigmentParkingDTO apd = new AssigmentParkingDTO(); 
    	Optional<AssigmentParkingDTO> assigmentParkingDTO = assigmentParkingService.findOne((long)1);
    	//AssigmentParkingDTO assignment = assigmentParkingDTO.get();
    	
		/*
		 * apd.setId(assignment.getId());
		 * apd.setParkingplaceId(assignment.getParkingplaceId());
		 * apd.setCarId(assignment.getCarId());
		 * apd.setEntryDateTime(assignment.getEntryDateTime());
		 */
    	
    	
    	Optional<AssigmentParkingDTO> assigmentParkingDTO1 = Optional.ofNullable(apd);
    	System.out.println("Optional AssignmentParkingDTO:"+ assigmentParkingDTO1.toString());
    	return ResponseUtil.wrapOrNotFound(assigmentParkingDTO);
    }

    /**
     * GET  /assigment-parkings/:id : get the "id" assigmentParking.
     *
     * @param id the id of the assigmentParkingDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the assigmentParkingDTO, or with status 404 (Not Found)
     */
    @GetMapping("/assigment-parkings/{id}")
    @Timed
    public ResponseEntity<AssigmentParkingDTO> getAssigmentParking(@PathVariable Long id) {
        log.debug("REST request to get AssigmentParking : {}", id);
        Optional<AssigmentParkingDTO> assigmentParkingDTO = assigmentParkingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(assigmentParkingDTO);
    }

    /**
     * DELETE  /assigment-parkings/:id : delete the "id" assigmentParking.
     *
     * @param id the id of the assigmentParkingDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/assigment-parkings/{id}")
    @Timed
    public ResponseEntity<Void> deleteAssigmentParking(@PathVariable Long id) {
        log.debug("REST request to delete AssigmentParking : {}", id);
        assigmentParkingService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
