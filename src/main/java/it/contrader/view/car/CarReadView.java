package it.contrader.view.car;

import it.contrader.controller.Request;
import it.contrader.dto.CarDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


/**
 * 
 * @author Maria Ilaria
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class CarReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public CarReadView() {
	}

	/**
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	
	@Override
	
	public void showResults(Request request) {
		if (request != null) {
			CarDTO car = (CarDTO) request.get("car");
			System.out.println(car);
			MainDispatcher.getInstance().callView("Car", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'auto da leggere
	 */
	
	@Override
	
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'auto:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	
	@Override
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Car", "doControl", request);
	}

}
