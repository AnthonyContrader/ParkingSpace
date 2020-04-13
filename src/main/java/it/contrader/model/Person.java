package it.contrader.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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
	@Getter(value=AccessLevel.NONE)
	//@Setter(value=AccessLevel.NONE)
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

