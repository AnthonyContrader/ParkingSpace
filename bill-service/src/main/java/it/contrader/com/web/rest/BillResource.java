package it.contrader.com.web.rest;

import com.codahale.metrics.annotation.Timed;

import it.contrader.com.security.SecurityUtils;
import it.contrader.com.service.AssignmentParkingService;
import it.contrader.com.service.BillService;
import it.contrader.com.service.RestServiceAuthentication;
import it.contrader.com.web.rest.errors.BadRequestAlertException;
import it.contrader.com.web.rest.util.HeaderUtil;
import it.contrader.com.web.rest.util.PaginationUtil;
import it.contrader.com.service.dto.AssignmentParkingDTO;
import it.contrader.com.service.dto.BillDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Bill.
 */
@RestController
@RequestMapping("/api")
public class BillResource {

	private final Logger log = LoggerFactory.getLogger(BillResource.class);

	private static final String ENTITY_NAME = "billBill";

	private final BillService billService;
	
	@Autowired
	private  AssignmentParkingService assignmentService;
	
	@Autowired
	private RestServiceAuthentication rest;
	
	@LoadBalanced
	private RestTemplate restTemplate;
	/*
	 * @Autowired private AuthenticateClientHttpRequestInterceptor interceptor;
	 */
	 
	/*
	 * @Value("${services.parkingspace.url}") protected String serviceUrl;
	 */
	public BillResource(BillService billService) {
		this.billService = billService;
	}

	/**
	 * POST /bills : Create a new bill.
	 *
	 * @param billDTO the billDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the new
	 *         billDTO, or with status 400 (Bad Request) if the bill has already an
	 *         ID
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
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /bills : Updates an existing bill.
	 *
	 * @param billDTO the billDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         billDTO, or with status 400 (Bad Request) if the billDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the billDTO
	 *         couldn't be updated
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
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, billDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /bills : get all the bills.
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and the list of bills in body
	 */
	@GetMapping("/bills")
	@Timed
	public ResponseEntity<List<BillDTO>> getAllBills(Pageable pageable) {
		updateAssignmentParkingTable();
		log.debug("REST request to get a page of Bills");
		Page<BillDTO> page = billService.findAll(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/bills");
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /bills/:id : get the "id" bill.
	 *
	 * @param id the id of the billDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the billDTO, or
	 *         with status 404 (Not Found)
	 */
	@GetMapping("/bills/{id}")
	@Timed
	public ResponseEntity<BillDTO> getBill(@PathVariable Long id) {
		log.debug("REST request to get Bill : {}", id);
		Optional<BillDTO> billDTO = billService.findOne(id);
		return ResponseUtil.wrapOrNotFound(billDTO);
	}

	/**
	 * DELETE /bills/:id : delete the "id" bill.
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
	
	@GetMapping("/getOne") 
	public List<AssignmentParkingDTO> getAssignments(){
		restTemplate = new RestTemplate();
		Optional<String> token = SecurityUtils.getCurrentUserJWT();
		String jwt1 = token.get();
		String jwt = "Bearer "+ jwt1;
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", jwt);
		
		HttpEntity request = new HttpEntity(headers);
		
		String uri = "http://localhost:4040/parkingspace/api/assigment-parkings";
		ResponseEntity<AssignmentParkingDTO[]> dto = restTemplate.exchange(uri, HttpMethod.GET, request, AssignmentParkingDTO[].class);	
		
		AssignmentParkingDTO[] assignment = dto.getBody();
		return Arrays.asList(assignment);
	}
    //save assginment of parkingspace on this database.
	public void updateAssignmentParkingTable() {
	    //dto di primo microservizio
		boolean isPresent;
		int cont;
		List<AssignmentParkingDTO> dto = getAssignments();
		Pageable pageable = PageRequest.of(0, 20, Sort.by(Order.asc("id")));
		//dto di questo microservizio
		Page<AssignmentParkingDTO> page = assignmentService.findAll(pageable);
		List<AssignmentParkingDTO> dto1 = page.getContent();
		System.out.println("\n    \n     \nSize list assignment : "+ dto1.size());
		if(dto1.size()==0) {
			saveAll(dto);
		}else{
			for(AssignmentParkingDTO b : dto) {
				isPresent = true;
				for(AssignmentParkingDTO a : dto1) {
					System.out.println("\n\n\n\n equalsAssig: "+equalsAssig(b,a));
					if(equalsAssig(b,a)) {
						isPresent = true;
						System.out.println("\n\n\n\n\nIsPresent di a:: "+ isPresent);
						break;
					}else
						isPresent = false;
				}
				System.out.println("\n\n\n\n\nIsPresent di b:: "+ isPresent);
				if(!isPresent) {
					assignmentService.save(b);
					System.out.println("\n \n \n size dto1 = "+ dto1.size());
				}
				
			}
			
			
			
		}		
	}
	public boolean equalsAssig(AssignmentParkingDTO a, AssignmentParkingDTO b) {
		return a.getCar() == b.getCar() && a.getEntryDateTime().equals(b.getEntryDateTime());
	}
	
	public void saveAll(List<AssignmentParkingDTO> dto) {
		for(AssignmentParkingDTO a : dto) {
			assignmentService.save(a);
		}
	}
	

}