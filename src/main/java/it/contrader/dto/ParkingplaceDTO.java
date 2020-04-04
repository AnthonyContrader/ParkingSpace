package it.contrader.dto;

public class ParkingplaceDTO {

	private int id;
	private int number_place;
	
	
	public ParkingplaceDTO() {
	}
	
	public ParkingplaceDTO( int numberplace) {
		this.number_place = numberplace;
	}
	
	public ParkingplaceDTO(int id, int numberplace) {
		this.id = id;
		this.number_place = numberplace;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumberplace() {
		return this.number_place;
	}
	
	public void setNumberplace(int numberplace) {
		this.number_place= numberplace;
	}
	
	@Override
	public String toString() {
		return id + "\t" + number_place;
	}
	
	}

