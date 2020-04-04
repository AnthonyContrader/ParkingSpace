package it.contrader.model;

public class Parkingplace {

	private int id;
	private int number_place;
	
	
	
	public Parkingplace() {
}
	
	
    public Parkingplace (int numberplace) {
	
	this.number_place= numberplace;
	
}
    public Parkingplace (int id, int numberplace) {
    	
    	this.id = id;
    	this.number_place= numberplace;
    	
    }
    
    
    public int getId() {
    	return this.id;
    }
	
    public void setId(int id) {
    	this.id= id;
    }
    
    public int getNumberplace() {
    	return this.number_place;
    }
    
    public void setNumberplace(int numberplace) {
    	this.number_place = numberplace;
    }
    
    @Override
    public String toString() {
    	return id + "\t" + number_place;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(this == obj)
    		return true;
    	if(obj == null)
    		return false;
    	if(getClass() != obj.getClass())
    		return false;
    	Parkingplace other = (Parkingplace) obj;
    	if(id != other.id)
    		return false;
    	if(number_place != other.number_place)
    		return false;
    	return true;
    	
    }
	
	
}
