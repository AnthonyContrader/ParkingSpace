package it.contrader.view.bill;

/**
 * @author comelli_laura
*/

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class BillInsertView extends AbstractView {

	private Request request;
	private int id_assignment;
	private double price;
	private boolean is_paid;
	private final String mode= "INSERT";
	
	public BillInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Inserimento andato a buon fine!");
			MainDispatcher.getInstance().callView("Bill" , null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("inserisci l' assegnazione car-parking: ");
		id_assignment = Integer.parseInt(getInput());
		System.out.println("Inserisci il prezzo da pagare: ");
		price = Double.parseDouble(getInput()); 
		System.out.println("Conferma il pagamento della fattura: ");
		is_paid = Boolean.parseBoolean(getInput()); 
		
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id_assignment", id_assignment);
		request.put("price", price);
		request.put("is_paid", is_paid);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Bill", "doControl" , request);
	}
		
}
