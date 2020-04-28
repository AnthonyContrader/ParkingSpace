package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ParkingplaceDTO;
import it.contrader.model.Parkingplace;

@Component
public class ParkingplaceConverter extends AbstractConverter<Parkingplace, ParkingplaceDTO> {

	@Override
	public Parkingplace toEntity(ParkingplaceDTO parkingplaceDTO) {
		Parkingplace parkingplace = null;
		if(parkingplaceDTO != null) {
			parkingplace = new Parkingplace(parkingplaceDTO.getId(),parkingplaceDTO.getNumberplace(),parkingplaceDTO.getFloor());
			
		}
		return parkingplace;
	}

	@Override
	public ParkingplaceDTO toDTO(Parkingplace parkingplace) {
		ParkingplaceDTO parkingplaceDTO = null;
		if(parkingplace != null) {
			parkingplaceDTO = new ParkingplaceDTO(parkingplace.getId(), parkingplace.getNumberplace(), parkingplace.getFloor());
		}

		return parkingplaceDTO;
	}
	

}
