package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.FloorConverter;
import it.contrader.dao.FloorRepository;
import it.contrader.dto.FloorDTO;
import it.contrader.model.Floor;

@Service
public class FloorService extends AbstractService<Floor , FloorDTO> {
	
	@Autowired
	private FloorConverter converter;
	
	@Autowired
	private FloorRepository repository;
	
	//creating a method equals to the one in repository , which takes the repository method and 
	//returns the same output converted to DTO 

	public FloorDTO findByNumberfloor(int number_floor){
		return converter.toDTO(repository.findByNumberfloor(number_floor));  
	}
	
	
}
