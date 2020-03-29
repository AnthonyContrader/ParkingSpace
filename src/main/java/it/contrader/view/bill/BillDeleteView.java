package it.contrader.view.bill;

/**
 * @author comelli_laura
*/

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class BillDeleteView extends AbstractView{
	
	private Request request ;
	private int id;
	private final String mode="DELETE";
	
	public BillDeleteView() {
	}
	
	@Override
	public void showResults(Request request) {
		/*if request is not null and the mode is delete*/
		if(request != null) {
			System.out.println("cancellazione andata a buon fine");  //print the instruction result 
			MainDispatcher.getInstance().callView("Bill" , null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("inserisci l'id della fattura da eliminare: ");
		id= Integer.parseInt(getInput());
	}
	
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Bill" , "doControl" , request);
	}
	
	

}
