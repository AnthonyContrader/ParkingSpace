package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.FloorDTO;
import it.contrader.service.FloorService;

@RestController
@RequestMapping("/floor")
@CrossOrigin(origins = "http://localhost:4200")
public class FloorController extends AbstractController <FloorDTO> {
	
	@Autowired
	private FloorService service;
	
	
}
