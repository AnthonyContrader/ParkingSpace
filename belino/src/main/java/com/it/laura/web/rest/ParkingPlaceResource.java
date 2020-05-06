package com.it.laura.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.it.laura.service.ParkingPlaceService;
import com.it.laura.web.rest.errors.BadRequestAlertException;
import com.it.laura.web.rest.util.HeaderUtil;
import com.it.laura.web.rest.util.PaginationUtil;
import com.it.laura.service.dto.ParkingPlaceDTO;
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
 * REST controller for managing ParkingPlace.
 */
@RestController
@RequestMapping("/api")
public class ParkingPlaceResource {

    private final Logger log = LoggerFactory.getLogger(ParkingPlaceResource.class);

    private static final String ENTITY_NAME = "belino1ParkingPlace";

    private final ParkingPlaceService parkingPlaceService;

    public ParkingPlaceResource(ParkingPlaceService parkingPlaceService) {
        this.parkingPlaceService = parkingPlaceService;
    }

    /**
     * POST  /parking-places : Create a new parkingPlace.
     *
     * @param parkingPlaceDTO the parkingPlaceDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new parkingPlaceDTO, or with status 400 (Bad Request) if the parkingPlace has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/parking-places")
    @Timed
    public ResponseEntity<ParkingPlaceDTO> createParkingPlace(@RequestBody ParkingPlaceDTO parkingPlaceDTO) throws URISyntaxException {
        log.debug("REST request to save ParkingPlace : {}", parkingPlaceDTO);
        if (parkingPlaceDTO.getId() != null) {
            throw new BadRequestAlertException("A new parkingPlace cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ParkingPlaceDTO result = parkingPlaceService.save(parkingPlaceDTO);
        return ResponseEntity.created(new URI("/api/parking-places/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /parking-places : Updates an existing parkingPlace.
     *
     * @param parkingPlaceDTO the parkingPlaceDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated parkingPlaceDTO,
     * or with status 400 (Bad Request) if the parkingPlaceDTO is not valid,
     * or with status 500 (Internal Server Error) if the parkingPlaceDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/parking-places")
    @Timed
    public ResponseEntity<ParkingPlaceDTO> updateParkingPlace(@RequestBody ParkingPlaceDTO parkingPlaceDTO) throws URISyntaxException {
        log.debug("REST request to update ParkingPlace : {}", parkingPlaceDTO);
        if (parkingPlaceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ParkingPlaceDTO result = parkingPlaceService.save(parkingPlaceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, parkingPlaceDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /parking-places : get all the parkingPlaces.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of parkingPlaces in body
     */
    @GetMapping("/parking-places")
    @Timed
    public ResponseEntity<List<ParkingPlaceDTO>> getAllParkingPlaces(Pageable pageable) {
        log.debug("REST request to get a page of ParkingPlaces");
        Page<ParkingPlaceDTO> page = parkingPlaceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/parking-places");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /parking-places/:id : get the "id" parkingPlace.
     *
     * @param id the id of the parkingPlaceDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the parkingPlaceDTO, or with status 404 (Not Found)
     */
    @GetMapping("/parking-places/{id}")
    @Timed
    public ResponseEntity<ParkingPlaceDTO> getParkingPlace(@PathVariable Long id) {
        log.debug("REST request to get ParkingPlace : {}", id);
        Optional<ParkingPlaceDTO> parkingPlaceDTO = parkingPlaceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(parkingPlaceDTO);
    }

    /**
     * DELETE  /parking-places/:id : delete the "id" parkingPlace.
     *
     * @param id the id of the parkingPlaceDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/parking-places/{id}")
    @Timed
    public ResponseEntity<Void> deleteParkingPlace(@PathVariable Long id) {
        log.debug("REST request to delete ParkingPlace : {}", id);
        parkingPlaceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
