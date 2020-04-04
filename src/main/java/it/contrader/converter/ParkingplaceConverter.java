package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ParkingplaceDTO;
import it.contrader.model.Parkingplace;

public class ParkingplaceConverter implements Converter<Parkingplace, ParkingplaceDTO> {

	@Override
	public ParkingplaceDTO toDTO(Parkingplace parkingplace) {
		ParkingplaceDTO parkingplaceDTO = new ParkingplaceDTO(parkingplace.getId(), parkingplace.getNumberplace());
		return parkingplaceDTO;
	}

	@Override
	public Parkingplace toEntity(ParkingplaceDTO parkingplaceDTO) {
		Parkingplace parkingplace = new Parkingplace(parkingplaceDTO.getId(), parkingplaceDTO.getNumberplace());
		return parkingplace;
	}

	@Override
	public List<ParkingplaceDTO> toDTOList(List<Parkingplace> parkingplaceList) {
		List<ParkingplaceDTO> parkingplaceDTOList = new ArrayList<ParkingplaceDTO>();
		for (Parkingplace parkingplace : parkingplaceList) {
			parkingplaceDTOList.add(toDTO(parkingplace));
		}
	
		return parkingplaceDTOList;
	}

}
