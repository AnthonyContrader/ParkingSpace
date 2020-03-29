package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ParkingplaceDTO;
import it.contrader.main.MainDispatcher;

public class ParkingplaceView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public ParkingplaceView() {
	}

	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n------------------- Gestione postiauto ----------------\n");
			System.out.println("ID\tNumberplace");
			System.out.println("----------------------------------------------------\n");
		
		@SuppressWarnings("unchecked")
		List<ParkingplaceDTO> parkingplaces = (List<ParkingplaceDTO>) request.get("parkingplaces");
		for(ParkingplaceDTO u: parkingplaces) 
			System.out.println(u.toString());
		System.out.println();
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("         Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice = getInput();
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Parkingplace", "doControl", this.request);
		
	}
}


