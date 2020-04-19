package it.contrader.dto;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	/*
	 * @Getter(value=AccessLevel.NONE) //@Setter(value=AccessLevel.NONE) private
	 * Set<Car> cars; public Set<Car> getCars() {
	 * System.out.println("sdajksjdajdaskjdas csajdadksajdasaskfasjfnask"); Set<Car>
	 * set = new HashSet<Car>(); for(Iterator<Car> it = set.iterator();
	 * it.hasNext();) { Car car = it.next(); cars.add(car); } return cars; }
	 */
}
