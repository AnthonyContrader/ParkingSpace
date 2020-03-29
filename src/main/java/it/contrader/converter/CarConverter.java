package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CarDTO;
import it.contrader.model.Car;


/**
 * 
 * @author Maria Ilaria
 * 
 */



public class CarConverter {
	
	/**
	 * Crea un oggetto di tipo CarDTO e lo riempie con i campi del parametro car di tipo Car.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo
	 */
	
	public CarDTO toDTO(Car car) {
		
		CarDTO carDTO = new CarDTO (car.getId(), car.getModel(), car.getLicense());
		return carDTO;
	}
	
	/**
	 * Crea un oggetto di tipo Car e lo riempie con i campi del parametro car di tipo CarDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	
	public Car toEntity(CarDTO carDTO) {
		Car car = new Car(carDTO.getId(), carDTO.getModel(), carDTO.getLicense());
		return car;
	}
	
	/**
	 * Metodo per convertire le liste di Car.
	 */
	public List<CarDTO> toDTOList(List<Car> carList) {
		//Crea una lista vuota.
		List<CarDTO> carDTOList = new ArrayList<CarDTO>();
		
		//Scorre tutti gli elementi della lista e li converte uno a uno
		
		for(Car car : carList) {
			
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			carDTOList.add(toDTO(car));
		}
		return carDTOList;
	}
}
