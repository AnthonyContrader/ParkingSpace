package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ParkingplaceDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ParkingplaceService;

//nel controller compaiono solo oggetti del dto e non del model

public class ParkingplaceController implements Controller {
	
	private static String sub_package = "parkingplace.";
	private ParkingplaceService parkingplaceService;
	
	public ParkingplaceController() {
		this.parkingplaceService = new ParkingplaceService();
	}
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		int id;
		int numberplace;
		
		switch (mode) {
		case "READ":
			//Integer.parseInt() serve per convertire il numero contenuto nella stringa in un numero intero
			id = Integer.parseInt(request.get("id").toString());
		    ParkingplaceDTO parkingplaceDTO = parkingplaceService.read(id);
		    request.put("parking_place",parkingplaceDTO);
		    //rimanda alla view con la risposta
		    MainDispatcher.getInstance().callView(sub_package + "ParkingplaceRead", request);
		    break;
		    
		case "INSERT":
			numberplace = Integer.parseInt(request.get("numberplace").toString());
			ParkingplaceDTO parkingplacetoinsert = new ParkingplaceDTO(numberplace);
			parkingplaceService.insert(parkingplacetoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ParkingplaceInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			parkingplaceService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ParkingplaceDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			numberplace = Integer.parseInt(request.get("numberplace").toString());
			ParkingplaceDTO parkingplacetoupdate = new ParkingplaceDTO(numberplace);
			parkingplacetoupdate.setId(id);
			parkingplaceService.update(parkingplacetoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ParkingplaceUpdate", request);
			break;
			
		case "PARKINGPLACELIST":
			List<ParkingplaceDTO> parkingplacesDTO = parkingplaceService.getAll();
			request.put("parkingplaces", parkingplacesDTO);
			MainDispatcher.getInstance().callView("Parkingplace",request);
			break;
			
		case "GETCHOICE":
			//il metodo toUpperCase () della stringa java restituisce la stringa in lettere maiuscole
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ParkingplaceRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ParkingplaceInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ParkingplaceUpdate", null);
				break;
				
			case "C" :
				MainDispatcher.getInstance().callView(sub_package + "ParkingplaceDelete", null);
				break;
					
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
					
			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			//default of switch(choice)	
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			//default of switch(mode)		
		default:
		MainDispatcher.getInstance().callView("Login", null);
		}
	}
} 
					
				
			
			
