package it.contrader.dto;

import it.contrader.model.Floor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingplaceDTO {
	
	private Long id;
	
	private int numberplace;
	
	private Floor floor;
	
	

}
