package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CarDTO;
import it.contrader.service.CarService;

@Controller

// mappa la request HTTP ai metodi di gestione MVC
@RequestMapping("/car")

public class CarController {
	
	@Autowired
	private CarService service;
	
	//@PostMapping("/login")
	//public String login(HttpServletRequest request, 
			//@RequestParam(value = "model", required = true) String model,
			//@RequestParam(value = "license", required = true) String license) {

		//CarDTO carDTO = service.findByModelAndLicense(model, license);
		//request.getSession().setAttribute("car", carDTO);

		//switch (userDTO.getUsertype()) {

		//case ADMIN:
			//return "homeadmin";

		//case USER:
			//return "index";

		//default:
			//return "index";
		//}

// gestisce la richiesta di get
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "cars";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "cars";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecar";
	}
	
	// scorciatoia per RequestMapping gestisce la richiesta post HTTP

	@PostMapping("/update")
	public String update(HttpServletRequest request, 
			@RequestParam("id") Long id, 
			@RequestParam("model") String model,
			@RequestParam("license") String license) {

		CarDTO dto = new CarDTO();
		dto.setId(id);
		dto.setModel(model);
		dto.setLicense(license);
		service.update(dto);
		setAll(request);
		return "cars";
		}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, 
			@RequestParam("model") String model,
			@RequestParam("license") String license) {
		CarDTO dto = new CarDTO();
		dto.setModel(model);
		dto.setLicense(license);
		service.insert(dto);
		setAll(request);
		return "cars";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, 
			@RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
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