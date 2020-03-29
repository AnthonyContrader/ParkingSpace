package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CarDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CarService;





/**
 * 
 * @author Maria Ilaria
 *
 *OSS: nel Controller compaiono solo oggetti del DTO e non del Model!
 *
 * Ogni classe controller è obbligata ad implemntare il metodo doControl
 */

// implements implementa tutti i metodi dell'interfaccia Controller nella mia classe

public class CarController implements Controller {
	
	// definisce il pacchetto di vista car.
	
	private static String sub_package = "car.";
	
	private CarService carService;
	
	/**
	 * Costruisce un oggetto di tipo CarService per poterne usare i metodi
	 */
	
	public CarController() {
		this.carService = new CarService();
	}
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	
	
	@Override
	
	// doControl è il metodo principale del Controller: ha come unico parametro una Request ovvero un pacchetto di info ad accesso.
	public void doControl(Request request) {
		
		//Il metodo conttolla che la richiesta non sia nulla, quindi la spacchetta estraendo o valori al suo interno con request.get
		
		// estrae mode
		String mode = (String) request.get("mode");
		
		// estrae choice
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String model;
		String license;
	

		switch (mode) {
		
		// Arriva qui dalla CarReadView. Invoca il Service con il parametro id e invia alla CarReadView un'auto da mostrare 
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			CarDTO carDTO = carService.read(id);
			request.put("car", carDTO);
			MainDispatcher.getInstance().callView(sub_package + "CarRead", request);
			break;
		
		// Arriva qui dalla CarInsertView. Estrae i parametri da inserire e chiama il service per inserire un'auto con questi parametri
		
		case "INSERT":
			model = request.get("model").toString();
			license = request.get("license").toString();
			
			//costruisce l'oggetto car da inserire
			CarDTO cartoinsert = new CarDTO(model, license);
			
			//invoca il service
			
			carService.insert(cartoinsert);
			request = new Request();
			request.put("mode", "mode");
			
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "CarInsert", request);
			break;
		
		// Arriva qui dalla CarDeleteView. Estrae l'id dell'auto da cancellare e lo passa al Service
		
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			
			//Qui chiama il service
			
			carService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CarDelete", request);
			break;
		
		// Arriva qui dalla CarUpdateView
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			model = request.get("model").toString();
			license = request.get("license").toString();
			
			CarDTO cartoupdate = new CarDTO(model,license);
			cartoupdate.setId(id);
			carService.update(cartoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CarUpdate", request);
			break;
			
		//Arriva qui dalla CarView Invoca il Service e invia alla CarView il risultato da mostrare 
		
		case "CARLIST":
			List<CarDTO> carsDTO = carService.getAll();
			
			//Impacchetta la request con la lista delle auto
			
			request.put("car", carsDTO);
			MainDispatcher.getInstance().callView("Car", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CarRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CarInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CarUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CarDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}

	
	
