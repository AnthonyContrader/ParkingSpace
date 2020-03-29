package it.contrader.view.parkingplace;

import it.contrader.controller.Request;
import it.contrader.dto.ParkingplaceDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ParkingplaceReadView extends AbstractView {
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public ParkingplaceReadView() {
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ParkingplaceDTO parkingplace = (ParkingplaceDTO) request.get("parking_place");
			System.out.println(parkingplace);
			MainDispatcher.getInstance().callView("Parkingplace", null);
		}
	}
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del Postoauto:");
		id = Integer.parseInt(getInput());
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Parkingplace", "doControl", request);
	}

}
