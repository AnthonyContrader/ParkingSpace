package it.contrader.view.assignmentParking;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * @author Esat
 * */
public class AssignmentParkingUpdateView extends AbstractView{
	private Request request;
	
	private int id;
	private int idCar;
	private int idPostiAuto;
	private final String mode = "UPDATE";
	
	public AssignmentParkingUpdateView() {
		
	}

	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("La modifica è stata effettuata.\n");
			MainDispatcher.getInstance().callView("AssignmentParking", null);
		}
		
	}
	/**
	 * Chiede all'utente di inserire gli attributi dell'assegnazione da modificare.
	 * */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'assegnazione:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci id della macchina:");
			idCar = Integer.parseInt(getInput());
			System.out.println("Inserisci id dell'posto auto:");
			idPostiAuto = Integer.parseInt(getInput());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Impacchetta la Request con i dati inseriti nel metodo showOption()
	 * */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("id_car", idCar);
		request.put("id_parkingplace", idPostiAuto);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("AssignmentParking", "doControl", request);
		
	}
		
}
