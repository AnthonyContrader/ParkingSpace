package it.contrader.dto;

import java.util.Set;

import it.contrader.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PersonDTO {
    
	private Long id;
	
	private String firstName;
	
	private String secondName;
	
	private Set<Car> cars;
}
