package it.contrader.dto;

import it.contrader.model.AssignmentParking;
import it.contrader.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
	
    
	private String license;
	
	private String model;
	
	private Person person;
	
	private AssignmentParking assignment;
    
}
