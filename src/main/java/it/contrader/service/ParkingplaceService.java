package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ParkingplaceConverter;
import it.contrader.dao.ParkingplaceRepository;
import it.contrader.dto.ParkingplaceDTO;
import it.contrader.model.Parkingplace;

@Service
public class ParkingplaceService extends AbstractService<Parkingplace, ParkingplaceDTO> {

	@Autowired
	private ParkingplaceConverter converter;
	@Autowired
	private ParkingplaceRepository repository;
	
	public ParkingplaceDTO findByNumberplace(int numberplace) {
		return converter.toDTO(repository.findByNumberplace(numberplace));
	}
}
