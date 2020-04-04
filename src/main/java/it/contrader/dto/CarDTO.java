package it.contrader.dto;

/**
 * 
 * 
 * Il DTO può contenere meno attributi del Model pur essendo simile.
 * Può contenere per esempio dati sensibili che non voglio far arrivare alle View.
 * Gli oggetti vengono trasformati da oggetti del Model a oggetti del DTO tramite i Converter (chiamati a loro volta dai Service).
 * 
 */


public class CarDTO {
	
	private int id;
	
	private String model;
	
	private String license;
	
	
	public CarDTO () {
		
	}
	
	public CarDTO(String model, String license) {
		this.model=model;
		this.license=license;
	}
	
	public CarDTO(int id, String model, String license) {
		this.id=id;
		this.model=model;
		this.license=license;
		
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getModel() {
		return this.model;
	}
	public void setModel(String model) {
		this.model=model;
	}
	
	public String getLicense() {
		return this.license;
	}
	public void setLicense(String license) {
		this.license=license;
	}
	
	@Override
	public String toString() {
		return id + "\t" + model + "\t\t" + license;
	}
	
	
	
}
