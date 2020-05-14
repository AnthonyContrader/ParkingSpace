package com.it.contrader.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.it.contrader.domain.Bill;
import com.it.contrader.domain.JsonResponseBody;
import com.it.contrader.repository.BillRepository;
import com.it.contrader.service.BillService;
import com.it.contrader.service.dto.AssignmentBDTO;
import com.it.contrader.service.dto.BillDTO;
import com.it.contrader.service.mapper.BillMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Bill.
 */
@Service
@Transactional
public class BillServiceImpl implements BillService {

    private final Logger log = LoggerFactory.getLogger(BillServiceImpl.class);

    private final BillRepository billRepository;

    private final BillMapper billMapper;

    public BillServiceImpl(BillRepository billRepository, BillMapper billMapper) {
        this.billRepository = billRepository;
        this.billMapper = billMapper;
    }

    /**
     * Save a bill.
     *
     * @param billDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BillDTO save(BillDTO billDTO) {
        log.debug("Request to save Bill : {}", billDTO);
        Bill bill = billMapper.toEntity(billDTO);
        bill = billRepository.save(bill);
        return billMapper.toDto(bill);
    }

    /**
     * Get all the bills.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BillDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Bills");
        return billRepository.findAll(pageable)
            .map(billMapper::toDto);
    }


    /**
     * Get one bill by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BillDTO> findOne(Long id) {
        log.debug("Request to get Bill : {}", id);
        return billRepository.findById(id)
            .map(billMapper::toDto);
    }

    /**
     * Delete the bill by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Bill : {}", id);
        billRepository.deleteById(id);
    }
    
	
	  @Override //metodo per copiare assignment di Parcheggio in assignment di Bill
	  public String getAvailableBills() {//String jwt) { 
		  
		  List<AssignmentBDTO> assignments = getAssignmentGivenJwt();//jwt);
		  
		  //List<LinkedHashMap> assignmentss = new  ArrayList<LinkedHashMap>(); 
		  if (assignments != null) {// && assignments.size() > 0) { 
			  //List<Long> assegnamento = new ArrayList<>(); 
			  //assegnamento = (List<AssignmentB>) assignments ; 
			  
			  for (AssignmentBDTO x : assignments) { 
				  //LinkedHashMap assignment = assignments.get(k);
				  //Long IdAssign =(Long) assignment.get("id");
				  
				  System.out.println(x.toString());
				  //assegnamento.add(IdAssign);
				  
			  //List<AssignmentB> assegnm = new ArrayList<>
			  }
			  return assignments.get(0).toString();
		  	//System.out.print("ASSEGNAMENTO COPIATO LENGHT: " + assegnamento.size() + " ; ASSEGNAMENTO IN RESPONSE LENGHT:" + assignments.size()); 
		  }
		return "assignment è vuoto"; 
		}
	  
	  //private List<AssignmentB> getAssignmentGivenJwt(String jwt){
	 // @ResponseBody
	  private List<AssignmentBDTO> getAssignmentGivenJwt(){//String jwt){
		  //MultiValueMap<String , String> headers = new LinkedMultiValueMap<>();
		  HttpHeaders headers = new HttpHeaders();
		  String jwt = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTU4OTQ1NjE2OX0.r38Im_vQV0RPJX6rt_GDwtC3-YBdiD0C0s-qNeYIeydrGL1pNDKQQUMCrBr7wsyvByYV9dblaStg7j7PGwsNzg";
		  //HttpEntity request = new HttpEntity(new LinkedMultiValueMap<String , String>()); //with headers and NO body
		  //headers = request.getHeaders();
		  System.out.print("\n \n \n CIAO1 CIAO1 CIAO1  \n \n");
		  headers.add("Authorization" , jwt);
		  HttpEntity request2 = new HttpEntity(headers);
		  
		  RestTemplate restTemplate = new RestTemplate();
		  ResponseEntity<AssignmentBDTO[]> responseEntity = restTemplate.exchange("http://localhost:4043/api/assigment-parkings",HttpMethod.GET , request2 , AssignmentBDTO[].class); 
		  AssignmentBDTO[] assign = responseEntity.getBody();
		  System.out.print("\n \n \n CIAO CIAO CIAO  \n \n");
		  //List<LinkedHashMap> assignments = (List<LinkedHashMap>) responseEntity.getBody();//.getResponse();
		  //assignments = (List<LinkedHashMap>) responseEntity.getBody().getResponse();
		  return  Arrays.asList(assign);//null; //assignments; 
		  }
	 
	  //togliere jwt--> dare indirixzzo statico del micro servizio
	  
}
