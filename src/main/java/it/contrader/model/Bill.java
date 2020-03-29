package it.contrader.model;

/**
 * @author comelli_laura
*/

public class Bill {
	
	private int id;
	private int id_assignment;
	private double price;
	private boolean is_paid;
	
	//constructors
	
	public Bill() {
		
	}
	
	public Bill(int id_assignment , double price , boolean is_paid) {
		this.id_assignment = id_assignment;
		this.price = price;
		this.is_paid = is_paid;
	}
	
	public Bill(int id , int id_assignment , double price , boolean is_paid) {
		this.id = id;
		this.id_assignment = id_assignment;
		this.price = price;
		this.is_paid = is_paid;
	}

	
	//get and set methods
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_assignment() {
		return id_assignment;
	}

	public void setId_assignment(int id_assignment) {
		this.id_assignment = id_assignment;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getIs_paid() {
		return is_paid;
	}

	public void setIs_paid(boolean is_paid) {
		this.is_paid = is_paid;
	}
	
	
	//toString methods
	
	public String toString() {
		return id + "\t\t" + id_assignment + "\t" + price + "\t" + is_paid ;
	}

	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (id != other.id)
			return false;
		if (id_assignment != other.id_assignment)
			return false;
		if (is_paid != other.is_paid)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	
	
	
}
