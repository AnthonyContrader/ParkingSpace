package it.contrader.service;

import it.contrader.converter.CarConverter;
import it.contrader.dao.CarDAO;
import it.contrader.dto.CarDTO;
import it.contrader.model.Car;

public class CarService extends AbstractService<Car, CarDTO>{
	
	// Inizializza DAO e Converter specifici
	
	public CarService() {
		
		this.dao = new CarDAO();
		this.converter = new CarConverter();
	}
	
	

}
