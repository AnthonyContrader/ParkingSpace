package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{
	
	private Request request;
	String choice;

	@Override
	public void showResults(Request request) {
		if(request!=null) {
	    	System.out.println("\n Benvenuto in ParkingPlace PROJECT " +request.get("username").toString() + "\n");
	    }

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("[A]ssignmentParking, [E]xit");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		
		request = new Request();
		switch (choice.toUpperCase()) {
		
		case "A":
			this.request.put("mode", "ASSIGNMENTPARKINGLIST");
        	MainDispatcher.getInstance().callAction("AssignmentParking", "doControl", request);
        	break;
		case "E":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
