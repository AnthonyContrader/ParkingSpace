package it.contrader.dto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.contrader.model.Car;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PersonDTO {
    
	private Long id;
	
	private String firstName;
	
	private String secondName;
	@Getter(value=AccessLevel.NONE)
	//@Setter(value=AccessLevel.NONE)
	private Set<Car> cars;
	public Set<Car> getCars() {
		System.out.println("sdajksjdajdaskjdas csajdadksajdasaskfasjfnask");
		Set<Car> set = new HashSet<Car>();
		for(Iterator<Car> it = set.iterator(); it.hasNext();) {
			Car car = it.next();
			cars.add(car);
		}
		return cars;
	}
}
