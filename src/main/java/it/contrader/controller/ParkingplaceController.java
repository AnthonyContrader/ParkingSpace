package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ParkingplaceDTO;
import it.contrader.service.ParkingplaceService;

@RestController
@RequestMapping("/parkingplace")
@CrossOrigin(origins="http://localhost:4200" )


public class ParkingplaceController extends AbstractController<ParkingplaceDTO> {
	
	@Autowired
	private ParkingplaceService parkingplaceservice;
	
	
}
