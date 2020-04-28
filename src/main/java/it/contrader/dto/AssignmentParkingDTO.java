package it.contrader.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Car;
import it.contrader.model.Parkingplace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class AssignmentParkingDTO {
	
	private Long id;
	
	private Car car;
	
	private Parkingplace park;
	
	private Date entryDate;
	
	private Date entryTime;
	
	public void setDate() {
		this.entryDate=java.sql.Date.valueOf(LocalDate.now());
		this.entryTime=java.sql.Time.valueOf(LocalTime.now());
	}
}

