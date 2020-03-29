package it.contrader.view.parkingplace;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ParkingplaceUpdateView extends AbstractView {
	
	private Request request;
	
	private int id;
	private int numberplace;
	private final String mode = "UPDATE";
	
	public ParkingplaceUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if(request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Parkingplace", null);
		}
		
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del postoauto:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci numberplace del postoauto:");
			numberplace = Integer.parseInt(getInput());
		} catch (Exception e) {	
			e.printStackTrace();
	
	}
	}
	@Override
	public void submit() {
	  request = new Request();
	  request.put("id", id);
	  request.put("numberplace", numberplace);
	  request.put("mode", mode);
	  MainDispatcher.getInstance().callAction("Parkingplace", "doControl", request);
	}
		
	}


