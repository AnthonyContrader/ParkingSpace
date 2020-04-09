package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Car {
	
	@Id
	@Column(name="license", nullable=false)
	private String license;
	
	private String model;
	
	
	@ManyToOne
	@JoinColumn(name="id_person", referencedColumnName = "id")
	
	private Person person;
}
