package it.contrader.view.assignmentParking;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * @author Esat
 * */
public class AssignmentParkingDeleteView extends AbstractView{
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public AssignmentParkingDeleteView() {
		
	}
	
	/**
	 * Se la request non è nulla(ovvero se si arriva dalla mode DELETE del controller),
	 * mostra l'esito dell'operazione.
	 * */
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("La cancellazione è stata effettuata.\n");
			MainDispatcher.getInstance().callView("AssignmentParking", null);
		}
	}
	
	/**
	 * Chiede l'id dell'assegnazione da cancellare
	 * */
	@Override
	public void showOptions() {
		System.out.println("Inserisci id dell'assegnazione da eliminare:");
		id = Integer.parseInt(getInput());	
	}
	
	/**
	 * Impacchetta la request con l'id dell'assegazione da cancellare fornita
	 * nel metodo showOptions()
	 * */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("AssignmentParking", "doControl", request);
	}

}
