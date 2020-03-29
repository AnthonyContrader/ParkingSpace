package it.contrader.view.assignmentParking;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * @author Esat
 * 
 * */
public class AssignmentParkingInsertView extends AbstractView{
	
	private Request request;
	
	private int idCar;
	private int idPostiAuto;
	private final String mode = "INSERT";
	
	public AssignmentParkingInsertView() {
		
	}
	/**
	 * Se la request != null(ovvero se si arriva dalla mode INSERT del controller), mostra
	 * l'esito dell'operazione
	 * */
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("Inserimento andato a buon fine. \n");
			MainDispatcher.getInstance().callView("AssignmentParking", null);
		}
		
	}
	/**
	 * Chiede di inserire gli attributi dell'assegnazione(AssignmentParking)
	 * */
	@Override
	public void showOptions() {
		//Inserisco manualmente ID della macchina e del PostoAuto
		System.out.println("Inserisci ID della macchina: ");
		idCar =Integer.parseInt(getInput().trim());
		System.out.println("Inserisci ID dell'posto auto");
		idPostiAuto =Integer.parseInt(getInput().trim());
		
	}

	@Override
	public void submit() {
		//non so se serve alla fine perchè questa classe nasce dall'interazione di Car-PostiAuto
		request = new Request();
		request.put("id_car", idCar);
		request.put("id_parkingplace", idPostiAuto);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("AssignmentParking", "doControl", request);
		
	}

}
