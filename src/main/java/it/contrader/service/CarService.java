package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CarConverter;
import it.contrader.dao.CarRepository;
import it.contrader.dto.CarDTO;
import it.contrader.model.Car;

@Service

public class CarService extends AbstractService<Car, CarDTO>{
	
	@Autowired
	private CarConverter converter;
	@Autowired
	private CarRepository repository;
	
	public CarDTO findByModelAndLicense (String model, String license) {
		return converter.toDTO(repository.findByModelAndLicense(model,license));
		
	}
	

}
