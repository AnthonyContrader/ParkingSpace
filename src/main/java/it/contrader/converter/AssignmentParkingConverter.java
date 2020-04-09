package it.contrader.converter;


import org.springframework.stereotype.Component;

import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.model.AssignmentParking;

@Component
public class AssignmentParkingConverter extends AbstractConverter<AssignmentParking,AssignmentParkingDTO>{
	
	@Override
	public AssignmentParking toEntity(AssignmentParkingDTO dto) {
		if(dto!=null) {
			return new AssignmentParking(dto.getId(),dto.getCar(),dto.getPark(),dto.getEntryDate(),dto.getEntryTime());
		}
		return null;
	}

	@Override
	public AssignmentParkingDTO toDTO(AssignmentParking entity) {
		if(entity!=null) {
			return new AssignmentParkingDTO(entity.getId(),entity.getCar(),entity.getParkingplace(),
					entity.getEntryDate(),entity.getEntryTime());
		}
		return null;
	}

}
