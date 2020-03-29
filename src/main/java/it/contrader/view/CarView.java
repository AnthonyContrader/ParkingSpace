package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CarDTO;
import it.contrader.main.MainDispatcher;

/**
 * 
 * @author Maria Ilaria
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */

// questa classe ESTENDE AbstractView dove è implementato il metodo getInput()

public class CarView extends AbstractView{
	
	private Request request;
	private String choice;
	
	public CarView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione auto ----------------\n");
			System.out.println("ID\tModel\tLicense");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CarDTO> cars = (List<CarDTO>) request.get("car");
			for (CarDTO u: cars)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi CarController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda al CarController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Car", "doControl", this.request);
	}

}
