package it.contrader.view.car;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CarUpdateView extends AbstractView {
	
	private Request request;
	private int id;
	private String model;
	private String license;
	private final String mode = "UPDATE";
	
	public CarUpdateView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */	

@Override
public void showResults(Request request) {
	if (request!=null) {
		System.out.println("Modifica andata a buon fine.\n");
		MainDispatcher.getInstance().callView("User", null);
	}
}

/**
 * Chiede all'utente di inserire gli attributi dell'utente da modificare
 */
@Override
public void showOptions() {
	try {
		System.out.println("Inserisci id dell'auto:");
		id = Integer.parseInt(getInput());
		
		System.out.println("Inserisci model dell'auto:");
		model = getInput();
		
		System.out.println("Inserisci license dell'utente:");
		license = getInput();
		} 
	
	catch (Exception e) {
		
	}
}


/**
 * Impacchetta la request con i dati inseriti nel metodo showOption()
 */

@Override

public void submit() {
	request = new Request();
	request.put("id", id);
	request.put("model", model);
	request.put("license", license);
	
	request.put("mode", mode);
	MainDispatcher.getInstance().callAction("Car", "doControl", request);
}

}
