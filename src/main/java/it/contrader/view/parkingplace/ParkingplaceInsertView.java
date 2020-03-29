package it.contrader.view.parkingplace;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ParkingplaceInsertView extends AbstractView {

	private Request request;
	private int numberplace;
	private final String mode = "INSERT";
	
	public ParkingplaceInsertView() {
	}

	@Override
	public void showResults(Request request) {
		if(request!= null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Parkingplace", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci numberplace del postoauto:");
		numberplace = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("numberplace", numberplace);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Parkingplace", "doControl", request);	
	}
	
}
	
	
	
	

