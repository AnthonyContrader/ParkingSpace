package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ParkingplaceDTO;
import it.contrader.model.Parkingplace;

public class ParkingplaceConverter {

	public ParkingplaceDTO toDTO(Parkingplace parkingplace) {
		ParkingplaceDTO parkingplaceDTO = new ParkingplaceDTO(parkingplace.getId(), parkingplace.getNumberplace());
		return parkingplaceDTO;
	}
	
	public Parkingplace toEntity(ParkingplaceDTO parkingplaceDTO) {
		Parkingplace parkingplace = new Parkingplace(parkingplaceDTO.getId(), parkingplaceDTO.getNumberplace());
		return parkingplace;
	}
	
	public List<ParkingplaceDTO> toDTOList(List<Parkingplace> parkingplaceList){
		List<ParkingplaceDTO> parkingplaceDTOList = new ArrayList<ParkingplaceDTO>();
		for(Parkingplace parkingplace : parkingplaceList) {
			parkingplaceDTOList.add(toDTO(parkingplace));
		}
		return parkingplaceDTOList;
	}
}
	
