package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.main.MainDispatcher;



/***
 * 
 * @author Esat
 * 
 * in view arrivano solo oggetti di tipo DTO
 * */
public class AssignmentParkingView extends AbstractView{
	
	private Request request;
	private String  choice;
	
	public AssignmentParkingView() {
		
	}
	
	//Mostra la lista di AssignmentParking
		@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n--------- Gestione Assegnazioni Macchina-PostoAuto ----------\n");
			System.out.println("                   ID\tIdCar\tIdPostoAuto");
			System.out.println("                  -----------------------\n");
			
			@SuppressWarnings("unchecked")
			List<AssignmentParkingDTO> assignmentParkingDTO = (List<AssignmentParkingDTO>) request.get("assignmentParkings");
			for(AssignmentParkingDTO apd: assignmentParkingDTO) {
				
				System.out.println(apd.toString());
			}
			System.out.println();
		}
		
	}
	//Chiede all'utente di inserire una lettera dalla tabella per la choice
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		//getInput() è stato implementato in AbstractView
		this.choice = getInput();
		
	}
	/**
	 * Crea un Request e la manda al AssignmentParkingController
	 * 
	 * */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("AssignmentParking", "doControl", this.request);
		
	}
	
}
