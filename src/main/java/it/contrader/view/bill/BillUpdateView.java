package it.contrader.view.bill;

/**
 * @author comelli_laura
*/

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class BillUpdateView extends AbstractView {
	
	private Request request;
	private int id;
	private int id_assignment;
	private double price;
	private boolean is_paid;
	private final String mode = "UPDATE";
	
	public BillUpdateView(){
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.print("Modifica avvenuta con successo");
			MainDispatcher.getInstance().callView("Bill" , null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
		System.out.println("Inserisci l'id della fattura da modificare: ");
		id = Integer.parseInt(getInput());   //convert the inserted number (inserted as a string) in a int
		System.out.println("Inserisci l'assegnazione della fattura per la modifica: ");
		id_assignment = Integer.parseInt(getInput());
		System.out.println("Inserisci il prezzo della fattura per la modifica: ");
		price = Double.parseDouble(getInput());		//convert the inserted number (inserted as a string) in a double
		System.out.print("Inserisci l'avvenuto o il mancato pagamento della fattura per la modifica: ");
		is_paid = Boolean.parseBoolean(getInput());   //convert the inserted number (inserted as a string) in a boolean
		}
		catch (Exception e) {
		}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id" , id);
		request.put("id_assignment", id_assignment);
		request.put("price", price);
		request.put("is_paid", is_paid);
		request.put("mode" ,mode);
		MainDispatcher.getInstance().callAction("Bill" , "doControl" , request);
	}
	
}