package it.contrader.dto;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Iterator;
import it.contrader.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PersonDTO {
	
    private Long id;
	
	private String firstName;
	
	private String secondName;
	private Set<Car> cars;
	public Set<Car> getCars() {
		
		Set<Car> set = new HashSet<Car>();
		for(Iterator<Car> it = set.iterator(); it.hasNext();) {
			Car car = it.next();
			cars.add(car);
		}
		return cars;
	}
	 
}
