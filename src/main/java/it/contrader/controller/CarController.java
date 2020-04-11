package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CarDTO;
import it.contrader.model.Person;
import it.contrader.service.CarService;

@Controller

// mappa la request HTTP ai metodi di gestione MVC

@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService service;
	
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
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
		System.out.println("sono nel preupdate di carcontroller ");
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
	public String insert(HttpServletRequest request, 
			@RequestParam("proprietario") Person idProprietario,
			@RequestParam("model") String model,
			@RequestParam("license") String license) throws Exception {
		if(service.findCar(license)!=null) {
			return "homeadmin";
		}
		CarDTO dto = new CarDTO();
		dto.setPerson(idProprietario);
		dto.setModel(model);
		dto.setLicense(license);
		service.insert(dto);
		setAll(request);
		return "cars";
	}
	

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("license") String license) {
		request.getSession().setAttribute("dto", service.findCar(license));
		return "readcar";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}

}