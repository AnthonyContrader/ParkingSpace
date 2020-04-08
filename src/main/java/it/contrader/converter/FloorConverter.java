package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.FloorDTO;
import it.contrader.model.Floor;

@Component
public class FloorConverter extends AbstractConverter <Floor , FloorDTO> {
	
	@Override
	public Floor toEntity(FloorDTO floorDTO) {
		Floor floor = null;
		if (floorDTO != null) {
			 floor = new Floor(floorDTO.getId() , floorDTO.getNumberfloor());
			}
		return floor;
	}
	
	@Override
	public FloorDTO toDTO(Floor floor) {
		FloorDTO floorDTO = null;
		if (floor != null) {
			floorDTO = new FloorDTO(floor.getId() , floor.getNumberfloor());
			}
		return floorDTO;
	}
	
	//toDTOList dichiarato in Converter è gia stato implementato in AbstractConverter--> come sappiamo una classe astratta non puo essere
	  //istanziata , quindi per richiamare la lista dovrò usare la classe FloorConverter()
}
