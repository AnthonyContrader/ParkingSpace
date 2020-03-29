package it.contrader.service;

import java.util.List;

import it.contrader.converter.CarConverter;
import it.contrader.dao.CarDAO;
import it.contrader.dto.CarDTO;


/**
 * 
 * @author Maria Ilaria
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */

public class CarService {
	
	private CarDAO carDAO;
	private CarConverter carConverter;
	
	// istanzio DAO e Converter specifici
	
	public CarService() {
		this.carDAO = new CarDAO ();
		this.carConverter = new CarConverter();
	}
	
	public List<CarDTO> getAll(){
		
		return carConverter.toDTOList(carDAO.getAll());
		}
	public CarDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		
		return carConverter.toDTO(carDAO.read(id));
	}


	public boolean insert(CarDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		
		return carDAO.insert(carConverter.toEntity(dto));
	}


	public boolean update(CarDTO dto) {
		// Converte un carDTO in entità e lo passa allo carDAO per la modifica
		
		return carDAO.update(carConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo metodo chiama direttamente il DAO
		
		return carDAO.delete(id);
	}
	

}


