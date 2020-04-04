package it.contrader.model;

public class Floor {

	private int id;
	private Integer number_floor;
	//private String floor_type;
	
	public Floor() {
	}
	
	public Floor( int number_floor) {
		this.number_floor = number_floor;
	}
	
	public Floor(int id , int number_floor) {
		this.id = id;
		this.number_floor = number_floor;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getNumber_floor() {
		return this.number_floor;
	}
	
	public void setNumber_floor(int number_floor) {
		this.number_floor = number_floor;
	}
	
	
	public boolean exists() {
		return this.getNumber_floor() == null;
	}
	
	public boolean compareToFloorNumber(Floor f1) {
		return this.getNumber_floor() == f1.getNumber_floor();
	}
	
	
	@Override
	public String toString() {
		return id + "/t" + number_floor ;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		
		if (this == object) {
			return true;
		}
		
		if (getClass() != object.getClass()) {
			return false;
		}
		
		Floor otherFloor = (Floor) object;
		
		if (id != otherFloor.id) {
			return false;
		}

		if (number_floor != null) {
			if (otherFloor.exists()) {
				return false;
			}
			else if (!this.compareToFloorNumber(otherFloor)) {
				return false;
				}			
			}
		if (number_floor != 0) {
			if (otherFloor.getNumber_floor() == 0) {
				return false;
			}else if (number_floor != otherFloor.getNumber_floor()) {
				return false;
			}
		}
		return true;	
		}
	
}










