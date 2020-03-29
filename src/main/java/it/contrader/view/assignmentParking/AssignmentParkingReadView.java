package it.contrader.view.assignmentParking;

import it.contrader.controller.Request;
import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * @author Esat
 * */
public class AssignmentParkingReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";
	
	
	public AssignmentParkingReadView() {
		
	}
	
	/**
	 * Se la request è null, il metodo è vuoto.
	 * Altrimenti se arriva con uno assegnazione di parcheggio nella request, mostra l'assegnazione.
	 * */
	@Override
	public void showResults(Request request) {
		if(request != null) {
			AssignmentParkingDTO assignmentParkingDTO = (AssignmentParkingDTO) request.get("assignmentParking");
			System.out.println(assignmentParkingDTO);
			MainDispatcher.getInstance().callView("AssignmentParking", null);
		}
		
	}

	/**
	 * chiede all'utente di inserire l'id dell'assegnazione da leggere
	 * */
	@Override
	public void showOptions() {
		System.out.println("Inserisce l'ID dell'assegnazione macchina-posto_auto");
		id = Integer.parseInt(getInput());
		
	}
	/**
	 * impacchetta una request con l'id di un'assegnazione da leggere e la manda al Controller tramite il Dispatcher.
	 * */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("AssignmentParking", "doControl", request);
		
	}
}
