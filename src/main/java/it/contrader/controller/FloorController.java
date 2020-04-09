package it.contrader.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.FloorDTO;
import it.contrader.service.FloorService;

@Controller
@RequestMapping("/floor")  //"floor" identifica il controller nella request 
public class FloorController {
	
	@Autowired
	private FloorService service;
	
	@GetMapping("/read")
	public String read (HttpServletRequest request , @RequestParam("id") Long id) {
		 //setAttribute(name="id_read" , obj=service.read(id)) --> "id-read" è lo stesso name che troviamo in getAttribute in readfloor
		request.getSession().setAttribute("dto_read" , service.read(id)); 
		return "readfloor";
	}
	
	public void setAll(HttpServletRequest request) {
		//setAttribute(name="floorlist" , obj=service.getAll()) --> "floorlist" è lo stesso name che troviamo in getAttribute in floors
		request.getSession().setAttribute("floorlist", service.getAll());  
	}
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {  //?perche non ritorna tipo List?
		setAll(request);
		return "floors";
	}
	
	@GetMapping("/delete")
	public String delete (HttpServletRequest request , @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "floors";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request , @RequestParam("number_floor") int number_floor) {
		FloorDTO floorInsert = new FloorDTO(); //(number_floor);
		floorInsert.setNumberfloor(number_floor);
		service.insert(floorInsert);
		setAll(request);
		return "floors";
	}

	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request , @RequestParam("id") Long id) {
		//setAttribute(name="id_update",obj=service.read(id)) --> "id_update" è stesso name che troviamo in getAttribute in updatefloor
		request.getSession().setAttribute("dto_update", service.read(id));
		return "updatefloor";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request ,@RequestParam("id") Long id , @RequestParam("number_floor") int number_floor) {
		FloorDTO floorUpdate = new FloorDTO();
		floorUpdate.setId(id);
		floorUpdate.setNumberfloor(number_floor);
		service.update(floorUpdate);
		setAll(request);
		return "floors";
	}
	
}
