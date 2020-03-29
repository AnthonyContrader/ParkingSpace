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
		 System.out.println("[C]ar [P]arkingPlace [A]ssignmentParking B[ill] [E]sci");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		
		request = new Request();
		
		
			switch (choice) {
	        	
	        case "C":
	        	this.request.put("mode", "CARLIST");
	        	MainDispatcher.getInstance().callAction("Car", "doControl", request);
	        	break;
	        	
	        case "P":
	        	this.request.put("mode", "PARKINGPLACELIST");
	        	MainDispatcher.getInstance().callAction("Parkingplace", "doControl", request);
	        	break;
	        	
	        case "A":
	        	this.request.put("mode", "ASSIGNMENTPARKINGLIST");
	        	MainDispatcher.getInstance().callAction("AssignmentParking", "doControl", request);
	        	break;
	        	
	        case "B":
	        	this.request.put("mode", "BILLLIST");
	        	MainDispatcher.getInstance().callAction("Bill", "doControl", request);
	        	break;
	        	
	        case "E":
	        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
	        	break;
	        default:
	            request.put("choice", choice);
	        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
		    }
	}
	

}
