package it.contrader.dto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.contrader.model.Parkingplace;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FloorDTO {
	
	private Long id;
	
	private int numberfloor;
	@Getter(value=AccessLevel.NONE)
	private Set<Parkingplace> parkingplaces;
	
	public Set<Parkingplace> getParkinglaces(){
		System.out.println("sdajksjdajdaskjdas csajdadksajdasaskfasjfnask");
		Set<Parkingplace> set = new HashSet<Parkingplace>();
		for(Iterator<Parkingplace> it = set.iterator(); it.hasNext();) {
			Parkingplace pp = it.next();
			parkingplaces.add(pp);
		}
		return parkingplaces;
	}	
}
