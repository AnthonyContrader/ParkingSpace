package it.contrader.view.car;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CarInsertView extends AbstractView{
	
	private Request request;
	private String model;
	private String license;
	
	private final String mode = "INSERT";
	
	public CarInsertView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	
	@Override
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Car", null);
		}
	}

	/**
	 * Chiede all'utente di caricare gli attributi dell'auto da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci model dell'auto:");
			model = getInput();
			System.out.println("Inserisci license dell'auto:");
			license = getInput();
			
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	
	@Override
	
	public void submit() {
		request = new Request();
		request.put("model", model);
		request.put("license", license);
		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Car", "doControl", request);
	}


}
