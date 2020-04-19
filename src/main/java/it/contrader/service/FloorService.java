package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.FloorRepository;
import it.contrader.dto.FloorDTO;
import it.contrader.model.Floor;

@Service
public class FloorService extends AbstractService<Floor , FloorDTO> {
	
	
	  public FloorDTO findByNumberfloor(int numberfloor) { return
	  converter.toDTO(((FloorRepository)repository).findByNumberfloor(numberfloor));
	  }
	 
}
