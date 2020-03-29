package it.contrader.dto;

public class ParkingplaceDTO {

	private int id;
	
	private int numberplace;

	public ParkingplaceDTO () {
		
	}

	public ParkingplaceDTO( int numberplace) {
		this.numberplace = numberplace;
	}
	
	public ParkingplaceDTO(int id, int numberplace) {
		this.id = id;
		this.numberplace = numberplace;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumberplace() {
		return this.numberplace;
	}
	
	public void setNumberplace(int numberplace) {
		this.numberplace = numberplace;
	}
	
	@Override
	public String toString() {
		return id + "\t" + numberplace;
	}
	
	}
	
	
		
	
