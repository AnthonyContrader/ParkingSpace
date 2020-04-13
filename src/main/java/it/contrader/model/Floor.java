package it.contrader.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="floor")

public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)  //non voglio due piani con lo stesso nome
	private int numberfloor; 
	
	@OneToMany(mappedBy="floor")
	private Set<Parkingplace> parkingplaces;
	
	public Set<Parkingplace> getParkinglaces(){
		//System.out.println("sdajksjdajdaskjdas csajdadksajdasaskfasjfnask");
		Set<Parkingplace> set = new HashSet<Parkingplace>();
		for(Iterator<Parkingplace> it = set.iterator(); it.hasNext();) {
			Parkingplace pp = it.next();
			parkingplaces.add(pp);
			System.out.println("adaskjdasjdjka");
		}
		return parkingplaces;
	}	
}

