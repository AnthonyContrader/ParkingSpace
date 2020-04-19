package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.FloorDTO;
import it.contrader.model.Floor;

@Component
public class FloorConverter extends AbstractConverter<Floor , FloorDTO> {
	
	@Override
	public FloorDTO toDTO(Floor floor) {
		FloorDTO floorDTO = null;
		if (floor != null) {
				floorDTO= new FloorDTO(floor.getId() , floor.getNumberfloor());
		}
		return floorDTO;
	}
	
	@Override
	public Floor toEntity(FloorDTO floordto) {
		Floor floors = null;
		if (floordto != null) {
			floors= new Floor (floordto.getId() , floordto.getNumberfloor());
		}
		return floors;
	}
	
	

}
