package it.contrader.service;

import it.contrader.converter.ParkingplaceConverter;
import it.contrader.dao.ParkingplaceDAO;
import it.contrader.dto.ParkingplaceDTO;
import it.contrader.model.Parkingplace;

public class ParkingplaceService extends AbstractService<Parkingplace, ParkingplaceDTO> {

	
	public ParkingplaceService() {
		this.dao= new ParkingplaceDAO();
		this.converter = new ParkingplaceConverter();
		
		
	}
}
