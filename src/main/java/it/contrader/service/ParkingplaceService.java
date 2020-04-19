package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ParkingplaceRepository;
import it.contrader.dto.ParkingplaceDTO;
import it.contrader.model.Parkingplace;

@Service

public class ParkingplaceService extends AbstractService<Parkingplace,ParkingplaceDTO> {

	public ParkingplaceDTO findByNumberplace(int numberplace) {
		return converter.toDTO(((ParkingplaceRepository)repository).findByNumberplace(numberplace));
	}
}
