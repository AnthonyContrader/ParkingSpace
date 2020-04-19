package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CarDTO;
//import it.contrader.CarDTO.LoginCarDTO;
import it.contrader.service.CarService;



@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {
	
	@Autowired
	private CarService service;
	
	@GetMapping("/getall")
	public Iterable<CarDTO> getAll(){
		return service.getAll();		
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") String license) {
		service.delete(license);
	}
	
	@PutMapping("/update")
	public CarDTO update(@RequestBody CarDTO CarDTO){
		service.update(CarDTO);
		return CarDTO;
	}
	
	@PostMapping("/insert")
	public CarDTO insert (@RequestBody CarDTO CarDTO) {
		service.insert(CarDTO);
		return CarDTO;
	}
	
	/*
	 * @GetMapping("/read") public CarDTO read(String license) { return
	 * service.read(license); }
	 */
}