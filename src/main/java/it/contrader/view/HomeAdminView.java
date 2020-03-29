/**
 * Manage a Business Owner view
 */

package it.contrader.view;


/**
 * Per Ulteriori dettagli vedi Guida sez 9 View.
 * Per la descrizione dei metodi vedi l'interfaccia View in questo pacchetto.
 */
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView extends AbstractView {

    private String choice;
    
	private Request request;

	/**
	 * Se la request non è nulla mostra un messaggio di benvenuto
	 */
    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("\n Benvenuto in ParkingPlace PROJECT " +request.get("username").toString() + "\n");
    	}
    }


    /**
     * Chiede all'utente di effettuare una scelta (da console)
     */
    public void showOptions() {
        System.out.println("-------------MENU------------\n");
        System.out.println(" Seleziona cosa vuoi gestire:");
        System.out.println("[U]tenti [C]ar [P]arkingPlace [A]ssignmentParking B[ill] [E]sci");
        //Il metodo che salva l'input nella stringa choice.
        //getInput() è definito in AbstractView.
        choice = this.getInput();
    }

    /**
     * Impacchetta una request (in base alla scelta sarà diversa) che invia ai controller tramite il
     * Dispatcher
     */
    public void submit() {    
    	//crea una nuova Request (vedi classe Request)
    	request = new Request();
        switch (choice) {
        case "U":
        	this.request.put("mode", "USERLIST");
        	MainDispatcher.getInstance().callAction("User", "doControl", request);
        	break;
        	
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
