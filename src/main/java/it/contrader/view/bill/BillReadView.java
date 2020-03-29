package it.contrader.view.bill;

/**
 * @author comelli_laura
*/

import it.contrader.controller.Request;
import it.contrader.dto.BillDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class BillReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";
	
	public BillReadView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			BillDTO bill = (BillDTO) request.get("bill");
			System.out.println(bill);
			MainDispatcher.getInstance().callView("Bill" , null);			
		}
	}
	
	@Override
	public void showOptions() {
		System.out.print("Inserisci l'id della fattura da visualizzare: ");
		id = Integer.parseInt(getInput());
		
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode" , mode);
		MainDispatcher.getInstance().callAction("Bill", "doControl", request);
	}
	
}