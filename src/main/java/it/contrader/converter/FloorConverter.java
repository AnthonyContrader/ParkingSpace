package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.FloorDTO;
import it.contrader.model.Floor;

public class FloorConverter implements Converter<Floor, FloorDTO> {

	@Override
	public FloorDTO toDTO(Floor floor) {
		FloorDTO floorDTO = new FloorDTO(floor.getId() , floor.getNumber_floor());
		return floorDTO;
	}
	
	@Override
	public Floor toEntity(FloorDTO floorDTO) {
		Floor floor = new Floor(floorDTO.getId() , floorDTO.getNumber_floor());
		return floor;
	}
	
	@Override
	public List<FloorDTO> toDTOList(List<Floor> floorList){
		List<FloorDTO> floorDTOList = new ArrayList<FloorDTO>();
		
		for (Floor f : floorList) {
			
			floorDTOList.add(toDTO(f));			
		}
		return floorDTOList;
	}
	
	
}
