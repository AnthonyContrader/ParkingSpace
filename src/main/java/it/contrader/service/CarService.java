package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.CarRepository;
import it.contrader.dto.CarDTO;
import it.contrader.model.Car;

@Service
public class CarService extends AbstractService<Car,CarDTO>{
	
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public CarDTO findByUsernameAndPassword(String model, String license) {
		return converter.toDTO(((CarRepository)repository).findByModelAndLicense(model, license));
		}

}
