package it.contrader.model;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@Entity

public class Car {
	@Id
	
	private String license;
	
	private String model;

	
	//@ManyToOne
	//@JoinColumn(name="id_person", referencedColumnName = "id")
	//@EqualsAndHashCode(exclude = {"id_person"})
	//private Person person;
	
	//@OneToOne(mappedBy="car",cascade=CascadeType.REMOVE)
	//private AssignmentParking assignment;
}