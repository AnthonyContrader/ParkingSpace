package it.contrader.dto;

/**
 * @author comelli_laura
 */

/*Instantiation of the same fields of model but in DTO type
	 * The CONVERTER will convert them from Entity to DTO and from DTO to Entity*/

public class BillDTO {

	//Declaration of the same fields of Bill_Model
	
	private int id;
	private int id_assignment;
	private double price;
	private boolean is_paid;
	
	//constructors
	
	public BillDTO() {
	}
	
	public BillDTO(int id_assignment , double price , boolean is_paid) {
		this.id_assignment = id_assignment;
		this.price = price;
		this.is_paid = is_paid;
	}
	
	public BillDTO(int id , int id_assignment , double price , boolean is_paid) {
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
		this.id_assignment= id_assignment;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price= price;
	}
	
	public boolean getIs_paid() {
		return is_paid;
	}
	
	public void setIs_paid(boolean is_paid) {
		this.is_paid= is_paid;
	}
	
	@Override
	public String toString() {
		return id + "\t\t" + id_assignment + "\t" + price + "\t" + is_paid;
	}
	
}
