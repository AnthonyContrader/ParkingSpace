package it.contrader.dao;
import java.sql.*;

//import java.lang.Integer; //I used the Integer class but IT does not give me back any error about not importing its class
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Bill;
/**
 * @author comelli_laura 
 */

public class BillDAO {
	
	private final String QUERY_ALL = "SELECT * FROM bill";
	private final String QUERY_CREATE = "INSERT INTO bill (id_assignment , price , is_paid) VALUES (? , ? , ?)";
	private final String QUERY_READ = "SELECT * FROM bill WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE bill SET id_assignment=? , price=? , is_paid=? WHERE id=? ";
	private final String QUERY_DELETE = "DELETE FROM bill WHERE id=?";
	
	public BillDAO() {
	}
	
	
	public List<Bill> getAllBill(){
		
		//Create object bills as empty arraylist (that i will fill with query QUERY_ALL result);
		List<Bill> billslist = new ArrayList<>(); 
		
		//Connecting SQL DB
		Connection connection = ConnectionSingleton.getInstance();    
		
		try {
			//Create object statement of class Statement to elaborate SQL instruction
			Statement statement = connection.createStatement();   
			
			/*Using  EXECUTEQUERY() method(of statement object) to execute query,return SQLresults saved in ResultSet*/				
			ResultSet resultset = statement.executeQuery(QUERY_ALL);    
			
			Bill bills; 
			
			/*Check rows of resultset Return a boolean value:if true->row is full->do the instruction*/ 	
			while (resultset.next()) {   
				
				//saving on the id/id_assign/price/is_paid int variable the value associated to fields in SQL
				int id = resultset.getInt("id");     
				
				int id_assignment = resultset.getInt("id_assignment");   
				
				double price = resultset.getDouble("price");  
				
				boolean is_paid = resultset.getBoolean("is_paid");  
				
				//filling bills object created before with variables filled with resultset.get() method
				bills = new Bill (id_assignment , price , is_paid);  
				
				bills.setId(id); 
				
				//adding my first row(=object) bills of resultset (equals to first row of SQLBill) to billslist
				billslist.add(bills);  
				
			}
		}
		
		//if SQL returns an exception
		catch (SQLException e) {  	
				
			//prints the error stack (turns back every step of the error)
			e.printStackTrace();  	
		}
		
		//return the billslist
		return billslist;   
	}
	
	
	//INSERT
	public boolean insert (Bill BillToInsert) {   
			//connecting to database
		Connection connection = ConnectionSingleton.getInstance();   
		try {
			
			/*using preparedStatm, specifying to SQLDB which instruction we want to execute
			Creating a preparedStmt object connected to SQL by connection and which use the preparedstatement method with QUERY as argument*/			
			PreparedStatement preparedStmt =(PreparedStatement) connection.prepareStatement(QUERY_CREATE); 
			
			 /*setVAR == PreparedStatement method used to setting input parameter values*/		
			preparedStmt.setInt(1, BillToInsert.getId_assignment()); 
			preparedStmt.setDouble(2 , BillToInsert.getPrice());
			preparedStmt.setBoolean(3, BillToInsert.getIs_paid());
			preparedStmt.execute();
			return true;
			  
			}
		
		//if connection with SQLquery generate an exception
		catch(SQLException e) {   
			System.out.println("Si è verificato un problema durante l'inserimento");
			return false;//return false
		}
	}
	
	
	//READ
	public Bill read (int id_toRead) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
			//connecting with query to SQL DB
			PreparedStatement preparedstmt =(PreparedStatement) connection.prepareStatement(QUERY_READ);  
			
			//passing as parameters the int variable bill_id
			preparedstmt.setInt(1 , id_toRead);  	 
			
			//saving in resultset the results of the query (data from SQL DB)
			ResultSet resultset = preparedstmt.executeQuery();  	
			resultset.next();
			
			int id_assignment;
			double price;
			boolean is_paid;
			
			/*saving in id_assignment/price/is_paid variables (created before) the value in SQLDB(in Bill table)*/
			
			id_assignment = resultset.getInt("id_assignment");
			price = resultset.getDouble("price");
			is_paid = resultset.getBoolean("is_paid");
			
			Bill bill_ToRead = new Bill(id_assignment , price , is_paid);
			
			bill_ToRead.setId(resultset.getInt("id"));
			
			return bill_ToRead;
		}
		
		//if connection to SQL returns an exception
		catch (SQLException e) {			
			System.out.println("Problema nella lettura dei dati in SQL");
			return null;
		}	
	}
	
	
	//UPDATE
	
	public boolean update(Bill BillToUpdate) {
		
		//connecting to database
		Connection connection = ConnectionSingleton.getInstance();
		
		//check if BillToUpdate_id is 0->if id == 0 ,return false and do not execute any instruction
		if (BillToUpdate.getId() == 0) {
			return false;   
		}
		
		/*using read_method (declared before) to search in SQLDB(in Bill table) a row with the given id*/
		Bill read_Bill = read(BillToUpdate.getId());
		
		/*comparing the two Bill object 
		 *checking if you r updating an object with the same object(it will return false) or with a different one,*/
		if (!read_Bill.equals(BillToUpdate)) {  
			
			/*some fields could not be going to be update.
				The first 3 IF_CYCLEs are checking which features of BillToUpdate are null->I'll fill in these fields the already existing values of read_bill*/
			try {
				
				//need to convert int in integer to check if is null
				Integer id_assignment_intg = new Integer(BillToUpdate.getId_assignment()); 
			
				if ( id_assignment_intg  == null || BillToUpdate.getId_assignment()== 0) {
					BillToUpdate.setId_assignment(read_Bill.getId_assignment());
					}
				if ( BillToUpdate.getPrice() == 0) {
					BillToUpdate.setPrice(read_Bill.getPrice());
					}
				
			/*	
				if (BillToUpdate.getIs_paid() == false) {  				
					BillToUpdate.setIs_paid(read_Bill.getIs_paid());
					}
				*/
				
				
				PreparedStatement preparedstmt =(PreparedStatement) connection.prepareStatement(QUERY_UPDATE);  //different in userDAO
				preparedstmt.setInt(1, BillToUpdate.getId_assignment());
				preparedstmt.setDouble(2 , BillToUpdate.getPrice());
				preparedstmt.setBoolean(3, BillToUpdate.getIs_paid());
				preparedstmt.setInt(4, BillToUpdate.getId());
				
				//executeUpdate returns an int
				int verify_update = preparedstmt.executeUpdate();					
				if (verify_update > 0) {
					return true;
					}
				else 
					{
					return false;
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					return false;
					}
				}
		return false;
	}
	
	
	//DELETE	
	public boolean delete(int id_ToDelete) {
		System.out.println(" sono dentro DELETE nel DAO");
		 Connection connection = ConnectionSingleton.getInstance();
		 
		 try {
			 
			 //verifying if the id_toDelete parameter exists
			 if (id_ToDelete == 0) {
				 return false;
			 }
			 
			 PreparedStatement preparedstmt =(PreparedStatement) connection.prepareStatement(QUERY_DELETE);
			 
			 /*set the id on the WHERE clause*/
			 preparedstmt.setInt(1 , id_ToDelete);  
			 
			 int verify_delete = preparedstmt.executeUpdate();
 
			 if (verify_delete != 0) {
				 return true;
				 }
			 else {
					 return false;
				 }
			 }
		 catch (SQLException e) {
			 e.printStackTrace();
			 return false;
		 	}			 
			 
		 }
	}

