package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.AssignmentParking;
import it.contrader.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="license")
public class CarDTO {
	
	private String license;
	
	private String model;
	
    private Person person;
	
	//private AssignmentParking assignment;

}
