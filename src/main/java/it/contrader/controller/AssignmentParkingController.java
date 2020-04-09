package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.contrader.service.AssignmentParkingService;
@Controller
@RequestMapping("/assignmentParking")
public class AssignmentParkingController {
	
	@Autowired
	public AssignmentParkingService service;
	
	@GetMapping("/getall")
	public String getall(HttpServletRequest request) {
		setall(request);
		return "assignments";
	}

	private void setall(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());		
	}
	
}
