package it.contrader.dto;

import java.util.Date;

import it.contrader.model.Car;
import it.contrader.model.Parkingplace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssignmentParkingDTO {
	
	public Long id;
	
	public Car car;
	
	public Parkingplace park;
	
	public Date entryDate;
	
	public Date entryTime;
}
