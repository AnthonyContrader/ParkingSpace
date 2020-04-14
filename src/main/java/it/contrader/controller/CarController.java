package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.PersonConverter;
import it.contrader.dto.CarDTO;
import it.contrader.dto.PersonDTO;
import it.contrader.service.CarService;
import it.contrader.service.PersonService;

@Controller

// mappa la request HTTP ai metodi di gestione MVC

@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService service;
	@Autowired
	private PersonService personService;
	@Autowired
	private PersonConverter converter;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		int a=5;
		return "cars";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam(name="id") String license) {
		System.out.println("Sono nel delete di car controller");
		service.delete(license);
		setAll(request);
		return "cars";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") String license) {
		request.getSession().setAttribute("dto", service.findCar(license));
		return "updatecar";
	}
	
	// scorciatoia per RequestMapping gestisce la richiesta post HTTP

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("model") String model, @RequestParam("id") String license) {
		System.out.println("sono nel update di carcontroller riga 50");
		CarDTO dto = service.findCar(license);
		dto.setModel(model);
		//dto.setLicense(license);
		service.update(dto);
		setAll(request);
		System.out.println("sono nel update di carcontroller");
		return "cars";
		}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("model") String model, 
			@RequestParam("license") String license,
			@RequestParam("nome")String nome, @RequestParam("cognome")String cognome) throws Exception {
		if(service.findCar(license)!=null) {
			return "homeadmin";
		}
		CarDTO dto = new CarDTO();
		//PersonDTO personDTO = new PersonDTO();
		
		dto.setModel(model);
		dto.setLicense(license);
		dto.setPerson(converter.toEntity(personService.findByFirstNameAndSecondName(nome, cognome)));
		service.insert(dto);
		setAll(request);
		return "cars";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") String license) {
		request.getSession().setAttribute("dto", service.findCar(license));
		return "readcar";
	}

	@GetMapping("/readByModel")
	public String readByModel(HttpServletRequest request, @RequestParam("id") String model) {
		request.getSession().setAttribute("dto", service.findCars(model));
		return "readbymodelcars";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		/*
		 * List<CarDTO> lists=service.findCars("Maserati");
		 * System.out.println("Ci sono maseratii:  "+lists.size());
		 * request.getSession().setAttribute("dto", service.findCars("Maserati"));
		 */
		//System.out.println("Il numero di entita Car = "+service.);
		request.getSession().setAttribute("list", service.getAll());
	}

}