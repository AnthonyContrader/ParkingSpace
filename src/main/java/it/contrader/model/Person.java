package it.contrader.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity


public class Person {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column 
	private String firstName;
	@Column
	private String secondName;
	
	@OneToMany(mappedBy="person")
	
	// Set non può contenere due elementi uguali
	
	private Set<Car> cars;

	
}

