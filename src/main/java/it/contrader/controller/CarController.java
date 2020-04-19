package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CarDTO;
//import it.contrader.dto.LoginDTO;
import it.contrader.service.CarService;



@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController extends AbstractController<CarDTO>{
	
	@Autowired
	private CarService carService;


	//POST Angular a CarDTO
	//@PostMapping(value = "/login")
	//public CarDTO login( @RequestBody LoginDTO loginDTO ) {
		//return carService.findByModelAndLicense(loginDTO.getModel(), loginDTO.getLicense());
	//}
}