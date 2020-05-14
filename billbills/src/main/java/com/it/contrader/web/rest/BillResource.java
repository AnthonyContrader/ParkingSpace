package com.it.contrader.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.it.contrader.domain.AssignmentB;
import com.it.contrader.domain.JsonResponseBody;
import com.it.contrader.service.BillService;
import com.it.contrader.web.rest.errors.BadRequestAlertException;
import com.it.contrader.web.rest.util.HeaderUtil;
import com.it.contrader.web.rest.util.PaginationUtil;
import com.it.contrader.service.dto.BillDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Bill.
 */
@RestController
@RequestMapping("/api")
public class BillResource {

    private final Logger log = LoggerFactory.getLogger(BillResource.class);

    private static final String ENTITY_NAME = "billbillBill";

    private final BillService billService;

    public BillResource(BillService billService) {
        this.billService = billService;
    }

    /**
     * POST  /bills : Create a new bill.
     *
     * @param billDTO the billDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new billDTO, or with status 400 (Bad Request) if the bill has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bills")
    @Timed
    public ResponseEntity<BillDTO> createBill(@RequestBody BillDTO billDTO) throws URISyntaxException {
        log.debug("REST request to save Bill : {}", billDTO);
        if (billDTO.getId() != null) {
            throw new BadRequestAlertException("A new bill cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BillDTO result = billService.save(billDTO);
        return ResponseEntity.created(new URI("/api/bills/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bills : Updates an existing bill.
     *
     * @param billDTO the billDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated billDTO,
     * or with status 400 (Bad Request) if the billDTO is not valid,
     * or with status 500 (Internal Server Error) if the billDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bills")
    @Timed
    public ResponseEntity<BillDTO> updateBill(@RequestBody BillDTO billDTO) throws URISyntaxException {
        log.debug("REST request to update Bill : {}", billDTO);
        if (billDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BillDTO result = billService.save(billDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, billDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bills : get all the bills.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of bills in body
     */
    @GetMapping("/bills")
    @Timed
    public ResponseEntity<List<BillDTO>> getAllBills(Pageable pageable) {
        log.debug("REST request to get a page of Bills");
        Page<BillDTO> page = billService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/bills");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /bills/:id : get the "id" bill.
     *
     * @param id the id of the billDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the billDTO, or with status 404 (Not Found)
     */
    @GetMapping("/bills/{id}")
    @Timed
    public ResponseEntity<BillDTO> getBill(@PathVariable Long id) {
        log.debug("REST request to get Bill : {}", id);
        Optional<BillDTO> billDTO = billService.findOne(id);
        return ResponseUtil.wrapOrNotFound(billDTO);
    }

    /**
     * DELETE  /bills/:id : delete the "id" bill.
     *
     * @param id the id of the billDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bills/{id}")
    @Timed
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {
        log.debug("REST request to delete Bill : {}", id);
        billService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
    
    
    
    
    /* try to let communication between micro services */
    @RequestMapping("/findBill")
    public ResponseEntity<JsonResponseBody> findBills(){//@RequestParam (value="jwt") String jwt){
    	//try {
    		System.out.print("SONO IN FINDBILL");
    		String bills = (String) billService.getAvailableBills();//jwt);
    		JsonResponseBody pippo = new JsonResponseBody(HttpStatus.OK.value(),bills);//);
    		return ResponseEntity.status(HttpStatus.OK).body(pippo);
    	//}
    	//catch(Exception e){
    	//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), e.toString())); //to be modified
    }
    //}
    
    //metodo per copiare assignment di Parcheggio in assignment di Bill
	/*
	 * public String getAvailableBills(String jwt) { List<AssignmentB> assignments =
	 * getAssignmentGivenJwt(jwt); List<AssignmentB> assignmentss = new
	 * ArrayList<AssignmentB>(); if (assignments != null && assignments.size() > 0)
	 * { //List<AssignmentB> assegnamento = assignments; //assegnamento =
	 * (List<AssignmentB>) assignments ; //while (assignment:) { for (int k=0 ; k <
	 * assignments.size(); k++) { assignmentss.add(assignments.get(k)); }
	 * System.out.print("ASSEGNAMENTO LUNGHEZZA : " + assignmentss.size()); } return
	 * "assignment è vuoto"; }
	 * 
	 * 
	 * private List<AssignmentB> getAssignmentGivenJwt(String jwt){
	 * MultiValueMap<String , String> headers = new LinkedMultiValueMap<>();
	 * headers.add("jwt", jwt); HttpEntity<?> request = new HttpEntity (
	 * String.class , headers); //with headers and NO body
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * ResponseEntity<JsonResponseBody> responseEntity =
	 * restTemplate.exchange("http://localhost:4043/parcheggio/assigment_parking",
	 * HttpMethod.POST , request , JsonResponseBody.class); List<AssignmentB>
	 * assignments = (List<AssignmentB>) responseEntity.getBody().getResponse();
	 * return assignments; }
	 */
}
