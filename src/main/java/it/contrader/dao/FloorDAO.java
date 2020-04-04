package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.contrader.model.Floor;
import it.contrader.utils.ConnectionSingleton;

public class FloorDAO implements DAO<Floor> {

	private String QUERY_ALL = "SELECT * FROM floor";
	private String QUERY_READ ="SELECT * FROM floor WHERE id=?";
	private String QUERY_CREATE = "INSERT INTO floor (number_floor) VALUES (?)";
	private String QUERY_UPDATE = "UPDATE floor SET number_floor=? WHERE id=?";
	private String QUERY_DELETE = "DELETE FROM floor WHERE id= ?";
	
	public FloorDAO() {
	}
	
	public List<Floor> getAll(){
		List<Floor> FloorList = new ArrayList<>();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery(QUERY_ALL);
			Floor floor;
			
			while (resultset.next()) {
				int id = resultset.getInt("id");
		//Java supports automatic boxing and unboxing, which means you can assign an Integer to an int without using .intValue()
				int number_floor = resultset.getInt("number_floor");
				
				floor = new Floor(number_floor);
				floor.setId(id);	
				
				FloorList.add(floor);
			}						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return FloorList;
	}
	
	public Floor read(int idToRead) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedstmt = connection.prepareStatement(QUERY_READ);
			preparedstmt.setInt(1, idToRead);
			ResultSet resultset = preparedstmt.executeQuery();
			resultset.next();
			
			int number_floor = resultset.getInt("number_floor");
			
			Floor FloorToRead = new Floor(number_floor);
			FloorToRead.setId(idToRead);
			
			return FloorToRead;
		}
		catch (SQLException e) {
			return null;
		}
	}
	
	public boolean insert(Floor FloorToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedstmt = connection.prepareStatement(QUERY_CREATE);
			preparedstmt.setInt(1, FloorToInsert.getNumber_floor());
			preparedstmt.execute();
			return true;
		}
		catch (SQLException e) {
			return false;
		}
		
	}
	
	public boolean update(Floor FloorToUpdate) {
		Connection connection= ConnectionSingleton.getInstance();
		
		System.out.println(this.read(FloorToUpdate.getNumber_floor()));
		
		if (FloorToUpdate.getId()==0) {
			return false;
		}
		
		Floor FloorRead = read(FloorToUpdate.getId());
		
		if (!FloorRead.equals(FloorToUpdate)) {
			try {
			
			
			//potrebbe non avere senso dato che se modifico , modifico!! se non inserisco che sto modificando?
			if (FloorToUpdate.exists() || FloorToUpdate.getNumber_floor()==0) {
				FloorToUpdate.setNumber_floor(FloorRead.getNumber_floor()); 
			}
			
			PreparedStatement preparedstmt = connection.prepareStatement(QUERY_UPDATE);
			preparedstmt.setInt(1,FloorToUpdate.getNumber_floor());
			preparedstmt.setInt(2, FloorToUpdate.getId());
			int verify_updating = preparedstmt.executeUpdate();
			if (verify_updating > 0) {
				return true;
			}
			else {
				return false;
			}
			
			}
			catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
	
	public boolean delete(int idToDelete) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedstmt = connection.prepareStatement(QUERY_DELETE);
			preparedstmt.setInt(1, idToDelete);
			
			int verify_deleting = preparedstmt.executeUpdate();
			if (verify_deleting != 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			return false;
		}
	}
	
	
}











