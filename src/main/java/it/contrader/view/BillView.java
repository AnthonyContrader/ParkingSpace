package it.contrader.view;

/**
 * @author comelli_laura
*/

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.BillDTO;
import it.contrader.main.MainDispatcher;

public class BillView extends AbstractView {

	private Request request;
	private String choice;
	
	//constructor
	public BillView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------- Gestione Fatture del parcheggio --------------\n");
			System.out.println("ID ----- ASSEGNAZIONE ------  PREZZO ------- PAGATO");
			System.out.println("----------------------------------------------------\n");	
			
			@SuppressWarnings("unchecked")
			List<BillDTO> bills = (List<BillDTO>) request.get("bills");
			for (BillDTO b : bills) {
				System.out.println(b);
			System.out.println();
			}
		}		
	}
	
	@Override
	public void showOptions() {
		System.out.println(" ______Scegli l'operazione da effettuare _________");
		System.out.println("  [L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci ");
		
		this.choice = getInput();
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Bill" , "doControl" , this.request);
	}
	
}