package it.contrader.service;

import it.contrader.converter.FloorConverter;
import it.contrader.dao.FloorDAO;
import it.contrader.dto.FloorDTO;
import it.contrader.model.Floor;

public class FloorService extends AbstractService<Floor , FloorDTO> {
	
	public FloorService() {
		this.dao = new FloorDAO();
		this.converter = new FloorConverter();
	}
	
}
