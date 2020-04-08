package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PersonDTO;
import it.contrader.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request, Long id) {
		setAll(request);
		return "persons";
	}
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "persons";
	}
	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id)	{
		request.getSession().setAttribute("dto", service.read(id));
		return "updateperson";
	}
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id")Long id, @RequestParam("firstName")String firstName, @RequestParam("secondName") String secondName) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(id);
		personDTO.setFirstName(firstName);
		personDTO.setSecondName(secondName);
		service.update(personDTO);
		setAll(request);
		return "persons";
		
	}
	@PostMapping("/insert")
    public String insert(HttpServletRequest request, @RequestParam("firstName")String firstName, @RequestParam("secondName") String secondName) {
    	PersonDTO personDTO = new PersonDTO();
    	personDTO.setFirstName(firstName);
    	personDTO.setSecondName(secondName);
    	service.insert(personDTO);
    	setAll(request);
    	return "persons";
    }
    
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id")Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readperson";
	}
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	
}
