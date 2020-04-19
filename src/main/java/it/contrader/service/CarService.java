package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CarConverter;
import it.contrader.dao.CarRepository;
import it.contrader.dto.CarDTO;

@Service
public class CarService{
	
	@Autowired
	private CarConverter converter;
	@Autowired
	private CarRepository repository;
	
	
	public CarDTO findCar(String license) {
		return converter.toDTO(repository.findByLicense(license));
	}
	public List<CarDTO> findCars(String model){
		return converter.toDTOList(repository.findCarsByModel(model));
	}
	public List<CarDTO> getAll(){
		System.out.println("Il numero di entita Car = "+ repository.count());
		return converter.toDTOList((repository.findAll()));
	}
	
	public void insert(CarDTO car) {
		repository.save(converter.toEntity(car));
	}
	public CarDTO update(CarDTO dto) {
		return converter.toDTO(repository.save(converter.toEntity(dto)));
	}
	public void delete(String license) {
		repository.deleteById(license);
	}
}
