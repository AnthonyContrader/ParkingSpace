package it.contrader.dto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Parkingplace;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class FloorDTO {

		
		private Long id;
		
		private int numberfloor;
		//@JsonProperty("Activity")
		/*
		 * @Getter(value=AccessLevel.NONE) private Set<Parkingplace> parkingplaces;
		 * 
		 * public Set<Parkingplace> getParkinglaces(){ Set<Parkingplace> set = new
		 * HashSet<Parkingplace>(); for(Iterator<Parkingplace> it = set.iterator();
		 * it.hasNext();) { Parkingplace pp = it.next(); parkingplaces.add(pp); } return
		 * parkingplaces; }
		 */
}
