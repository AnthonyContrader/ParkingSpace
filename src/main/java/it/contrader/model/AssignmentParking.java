package it.contrader.model;

import java.time.LocalDateTime;
/**
 * 
 * @author Esat
 * 
 * */
public class AssignmentParking {
	
	private  int id;
	private  int idCar;
	private  int idPostiAuto;
	//private  LocalDateTime entryTime;
	//private  LocalDateTime exitTime;
	
	public AssignmentParking() {
		
	}
	
	public AssignmentParking(int idCar,int idPostiAuto) {
		this.idCar       = idCar;
		this.idPostiAuto = idPostiAuto;
	}
	
	public AssignmentParking(int id,int idCar,int idPostiAuto) {
		this.id 		 = id;
		this.idCar       = idCar;
		this.idPostiAuto = idPostiAuto;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public int getIdPostiAuto() {
		return idPostiAuto;
	}

	public void setIdPostiAuto(int idPostiAuto) {
		this.idPostiAuto = idPostiAuto;
	}

	@Override
	public boolean equals(Object obj) {
		//self check
		if(this == obj) {
			return true;
		}
		//null check
		if(obj == null) {
			return false;
		}
		//type check and cast
		if(getClass()!=obj.getClass()) {
			return false;
		}
		AssignmentParking ap = (AssignmentParking) obj;
		//field Comparison
		if(id != ap.id) {
			return false;
		}
		if(idCar!=ap.idCar && idPostiAuto != ap.idPostiAuto) {
			return false;	
		}
		
		return true;
		
	}

	@Override
	public String toString() {
		return  id + "\t"  + idCar +"\t\t" +   idPostiAuto;
	}
	

	
	
	
	
}
