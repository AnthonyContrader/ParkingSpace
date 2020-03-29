package it.contrader.controller;

import java.util.List;

import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.AssignmentParkingService;

/**
 *
 *   @author Esat
 * 
 * 
 * */
public class AssignmentParkingController implements Controller{
	/***
	  definisce il pacchetto di vista assignmentParking.
	  
	  */
	
	private static String sub_package = "assignmentParking.";
	
	private AssignmentParkingService assignmentParkingService;
	
	/**
	 * Costruisce un object di tipo AssignmentParkingService per poterne usare i metodi
	 * 
	 * */
	
	public AssignmentParkingController() {
		this.assignmentParkingService = new AssignmentParkingService();
	}
	
	/**
	 * Estrae dalla request la "mode"  e "choice" dell'utente
	 * */
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		
		
		//definisce i campi  della classe
		int id, id_car, id_parkingplace;
		
		switch(mode) {
		//Arriva qui dalla AssignmentParkingReadView. Invoca il Service con il parametro id e invia alla AssignmentParkingReadVeiw un AssignmentParking da mostrare
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			AssignmentParkingDTO assignmentParkingDTO = assignmentParkingService.read(id);
			request.put("assignmentParking", assignmentParkingDTO);
			MainDispatcher.getInstance().callView(sub_package +"AssignmentParkingRead", request);
		    break;
		    
		//Arriva qui dalla AssignmentParkingInsertView. Extract i parametri da inserire e call il service per inserire uno AssignmentParking.
		    
		    
		case "INSERT":
			id_car = (int) request.get("id_car");
			id_parkingplace = (int) request.get("id_parkingplace");
			//Costruire l'oggetto AssignmentParking da inserire
			AssignmentParkingDTO assignmentParkingToInsert = new AssignmentParkingDTO(id_car, id_parkingplace);
			//invoca il service
			assignmentParkingService.insert(assignmentParkingToInsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "AssignmentParkingInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			assignmentParkingService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "AssignmentParkingDelete", request);
			break;
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			id_car = (int) request.get("id_car");
			id_parkingplace = (int) request.get("id_parkingplace");
			
			AssignmentParkingDTO assignmentParkingToUpdate = new AssignmentParkingDTO(id_car, id_parkingplace);
			assignmentParkingToUpdate.setId(id);
			
			assignmentParkingService.update(assignmentParkingToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "AssignmentParkingUpdate", request);
			break;
		
		case "ASSIGNMENTPARKINGLIST":
			List<AssignmentParkingDTO> assignmentsParkingDTO = assignmentParkingService.getAll();
			//Impacchetta la request con la lista degli assignmentParkings
		    request.put("assignmentParkings", assignmentsParkingDTO);
		    MainDispatcher.getInstance().callView("AssignmentParking", request);
		    break;
		    
		//esegue uno switch sulla base del comando inserito dall'utente
		//e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL 
		case "GETCHOICE":
			switch(choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "AssignmentParkingRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "AssignmentParkingInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "AssignmentParkingUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "AssignmentParkingDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
		}
	}

}
