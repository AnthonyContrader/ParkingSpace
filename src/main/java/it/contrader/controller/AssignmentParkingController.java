package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.converter.CarConverter;
import it.contrader.converter.ParkingplaceConverter;
import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.dto.CarDTO;
import it.contrader.dto.ParkingplaceDTO;
import it.contrader.model.Car;
import it.contrader.model.Parkingplace;
import it.contrader.service.AssignmentParkingService;
import it.contrader.service.CarService;
import it.contrader.service.ParkingplaceService;
@Controller
@RequestMapping("/assignmentParking")
public class AssignmentParkingController {
	
	@Autowired
	public AssignmentParkingService service;
	@Autowired
	public CarService carService;
	@Autowired
	public ParkingplaceService parkService;
	@Autowired
	public CarConverter carConverter;
	@Autowired
	public ParkingplaceConverter converter;
	
	@GetMapping("/getall")
	public String getall(HttpServletRequest request) {
		setall(request);
		return "assignments";
	}
	/*
	 * @PostMapping public String insert(HttpServletRequest
	 * request, @RequestParam("id")String license) {
	 * 
	 * //creo una AssignmentParkingDTO AssignmentParkingDTO dto = null;
	 * //dto.setCar(CarDTO.); //service.insert(dto); return license;
	 * 
	 * }
	 */
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id")Long id) {
		//ho id preso da View e tramite il service vado a recuperare l'oggetto in database
		AssignmentParkingDTO dto = null;
		dto = service.read(id);
		request.getSession().setAttribute("dto", dto);
		return "readassignments";
	}
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("license")String license, @RequestParam("numberplace")int numberplace) {
		System.out.print(license);
		System.out.println(numberplace);
		AssignmentParkingDTO apd = new AssignmentParkingDTO();
		//CarDTO car = carConverter.toEntity(carService.findCar(license));
		CarDTO car = carService.findCar(license);
		Car c = carConverter.toEntity(car);
		ParkingplaceDTO ppd = parkService.findByNumberplace(numberplace);
		//System.out.println(ppd.toString());
		Parkingplace pp = converter.toEntity(ppd);
		apd.setCar(c);
		apd.setPark(pp);
		//add current Date and Time on object AssignmentParkingDTO
		apd.setDate();
		service.insert(apd);
		setall(request);
		return ("assignments");
	}
	@GetMapping("/preupdate")
	public String preupdate(HttpServletRequest request, @RequestParam("id")Long id) {
		/*
		 * System.out.println("ffffffaaaaaaalllllllsssssssseeeeeeeeeeeeeee");
		 * AssignmentParkingDTO dto=service.read(id); if(dto.equals(null)) {
		 * System.out.println("ffffffaaaaaaalllllllsssssssseeeeeeeeeeeeeee"); }
		 * System.out.println("after apd.dto"+dto.toString());
		 */
		System.out.println("dentro preupdate");
		request.getSession().setAttribute("dto", service.read(id));
		System.out.println("121111192391293919239129391239123");
		//System.out.println("sono in preupdate");
		return "updateassignments";
	}
	@PostMapping("/update")
	public String update(HttpServletRequest request,@RequestParam("id")Long id, @RequestParam("license")String license, @RequestParam("numberplace")int numberplace) {
		System.out.println("inizio di update");
		//recupero object car tramite license, e object parkingplace tramite numberplace
		CarDTO car = carService.findCar(license);
		ParkingplaceDTO ppd = parkService.findByNumberplace(numberplace);
		System.out.println(car.toString());
		System.out.println(ppd.toString());
		AssignmentParkingDTO dto = new AssignmentParkingDTO();
		dto.setId(id);
		dto.setCar(carConverter.toEntity(car));
		dto.setPark(converter.toEntity(ppd));
		dto.setDate();
		service.update(dto);
		setall(request);
		return "assignments";
	}
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id")Long id) {
		service.delete(id);
		setall(request);
		return "assignments";
	}
	private void setall(HttpServletRequest request) {
		//control if come from insert method
		//if(request.getParameter("/insert"))
		//request.getSession().setAttribute("parkList", parkService.getAll());
		//request.getSession().setAttribute("carList", carService.getAll());
		request.getSession().setAttribute("list", service.getAll());		
	}
	/*
	 * @PostMapping public CarDTO getCarFromLicense(HttpServletRequest
	 * request, @RequestParam("license")String license){ CarDTO car =
	 * carService.findCar(license); return car;
	 * 
	 * }
	 */
	
	
}
