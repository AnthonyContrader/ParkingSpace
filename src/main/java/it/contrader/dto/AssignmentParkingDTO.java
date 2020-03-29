package it.contrader.dto;
/**
 * 
 * @author Esat
 * 
 * */
public class AssignmentParkingDTO {
	private  int id;
	private  int id_car;
	private  int id_parkingplace;
	
    public AssignmentParkingDTO() {
		
	}
	
	public AssignmentParkingDTO(int id_car,int id_parkingplace) {
		this.id_car       = id_car;
		this.id_parkingplace = id_parkingplace;
	}
	
	public AssignmentParkingDTO(int id, int id_car,int id_parkingplace) {
		this.id 		 = id;
		this.id_car       = id_car;
		this.id_parkingplace = id_parkingplace;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCar() {
		return id_car;
	}

	public void setIdCar(int id_car) {
		this.id_car = id_car;
	}

	public int getIdPostiAuto() {
		return id_parkingplace;
	}

	public void setIdPostiAuto(int id_parkingplace) {
		this.id_parkingplace = id_parkingplace;
	}

	@Override
	public String toString() {
		return  id + "\t"  + id_car +"\t\t" +   id_parkingplace;
	}
	
	
}
