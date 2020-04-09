package it.contrader.dto;

import java.util.Set;

import it.contrader.model.Parkingplace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FloorDTO {
	
	private Long id;
	
	private int numberfloor;
	
	private Set<Parkingplace> Parking_place;
}
