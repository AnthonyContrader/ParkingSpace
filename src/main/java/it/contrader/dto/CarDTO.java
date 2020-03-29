package it.contrader.dto;


/**
 * 
 * @author Maria Ilaria
 * 
 * Il DTO contiene meno attributi rispetto al Model
 * (ad esempio dati sensibili che non devono arrivare alla View)
 * Gli oggetti vengono trasformati da oggetti del model a oggetti 
 * del DTO tramite i Converter (chiamati dai Service).
 * Per la descrizione della classe si fa riferimento al Model "Car"
 * 
 * */

public class CarDTO{
	

	private int id;
	
	private String model;
	
	private String license;
	
	
	public CarDTO() {
	}
	
	public CarDTO (String model, String license) {
		
		this.model = model;
		this.license = license;
	}
	
	public CarDTO (int id, String model, String license) {
		
		this.id = id;
		this.model = model;
		this.license = license;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModel () {
		return this.model;
	}
	public void setModel() {
		this.model = model;
	}
	
	public String getLicense () {
		return this.license;
	}
	public void setLicense() {
		this.license = license;
	}
	
	@Override
	
	public String toString () {
		return id + "\t" + model +"\t\t" + license;
	}
}



