package it.contrader.model;

public class Car {
	
	private int id;
	
	private String model;
	
	private String license;
	
	// Definisco un costruttore vuoto
	
	public Car () {
	}
	
	// Definisco un costruttore semipieno
	
	public Car ( String model, String license) {
		
		this.model=model;
		this.license=license;
	}
	
	// Definisco un costruttore pieno
	
	public Car (int id, String model, String license) {
		
		this.id=id;
		this.model=model;
		this.license=license;
	}
	
	// I metodi get e setter sono necessari alle altre classi per recuperare e modificare gli attributi di Car
	
	public int getId() {
		return this.id;
	}
	public void setId (int id) {
		this.id= id;
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
	public void setLicense (String license) {
		this.license=license;
	}
	
	// Uso il metodo ToString per trasformare l'oggetto in una stinga
	
	@Override
	public String toString () {
		return id + "\t" + model + "\t\t" + license;
		
	}
	
	// Uso il metodo equals per il confronto degli oggetti
	
	@Override 
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		if (getClass () != obj.getClass())
			return false;
		Car other = (Car) obj;
		
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		
		return true;
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
