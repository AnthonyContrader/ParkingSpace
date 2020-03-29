package it.contrader.service;

import java.util.List;

import it.contrader.converter.ParkingplaceConverter;
import it.contrader.dao.ParkingplaceDAO;
import it.contrader.dto.ParkingplaceDTO;

public class ParkingplaceService {

	private ParkingplaceDAO parkingplaceDAO;
	private ParkingplaceConverter parkingplaceConverter;
	
	public ParkingplaceService() {
		this.parkingplaceDAO = new ParkingplaceDAO();
		this.parkingplaceConverter = new ParkingplaceConverter();
	}
	
	public List<ParkingplaceDTO> getAll() {
		return parkingplaceConverter.toDTOList(parkingplaceDAO.getAll());	
	}
	
	public ParkingplaceDTO read(int id) {
		return parkingplaceConverter.toDTO(parkingplaceDAO.read(id));
		
	}
	public boolean insert(ParkingplaceDTO dto) {
		return parkingplaceDAO.insert(parkingplaceConverter.toEntity(dto));
	}
	public boolean update(ParkingplaceDTO dto) {
		return parkingplaceDAO.update(parkingplaceConverter.toEntity(dto));
	}
	public boolean delete(int id) {
		return parkingplaceDAO.delete(id);
	}
}
