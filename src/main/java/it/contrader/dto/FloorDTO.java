package it.contrader.dto;

public class FloorDTO {

	private int id;
	private Integer number_floor;
	
	public FloorDTO() {
	}
	
	public FloorDTO(int number_floor) {
		this.number_floor = number_floor;
	}
	
	public FloorDTO(int id , int number_floor) {
		this.id = id;
		this.number_floor = number_floor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber_floor() {
		return this.number_floor;
	}

	public void setNumber_floor(int number_floor) {
		this.number_floor = number_floor;
	}

	@Override
	public String toString() {
		return id + "\t" + number_floor;
	}
	
	
	
	
}
