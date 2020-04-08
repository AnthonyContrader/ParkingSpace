package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ParkingplaceDTO;
import it.contrader.service.ParkingplaceService;

@Controller
@RequestMapping("/parkingplace")

public class ParkingplaceController {
	
	@Autowired
	private ParkingplaceService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "parkingplaces";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id ) {
		service.delete(id);
		setAll(request);
		return "parkingplaces";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateparkingplace";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("numberplace") int numberplace ) {
	 
		ParkingplaceDTO dto = new ParkingplaceDTO();
		dto.setId(id);
		dto.setNumberplace(numberplace);
		service.update(dto);
		setAll(request);
		return "parkingplaces";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("numberplace") int numberplace) {
		ParkingplaceDTO dto = new ParkingplaceDTO();
		dto.setNumberplace(numberplace);
		service.insert(dto);
		setAll(request);
		return "parkingplaces";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id ) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readparkingplace";
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list",service.getAll());
	}
}
