package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.AssignmentParking;
/**
 * 
 * @author Esat
 * 
 * */
public class AssignmentParkingDao {
	private final String QUERY_ALL = "Select * from assignment_park";
	private final String QUERY_CREATE = "Insert into assignment_park(id_car, id_parkingplace) values (?,?)";
	private final String QUERY_READ   = "Select * from assignment_park WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE assignment_park SET id_car=?, id_parkingplace=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE from assignment_park WHERE id=?";
	
	
	public AssignmentParkingDao() {}
	/**
	 * Return list of AssignmentParking, after made the query on Database
	 * 
	 * @param  null
	 * @return list of AssignmentParking
	 * */
	public List<AssignmentParking> getAll(){
		List<AssignmentParking> listAssignmentParking = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement   = connection.createStatement();
			ResultSet resultSet   = statement.executeQuery(QUERY_ALL);
			AssignmentParking assignmentParking;
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int idCar = resultSet.getInt("id_car");
				int idPostiAuto = resultSet.getInt("id_parkingplace");
				assignmentParking = new AssignmentParking(id,idCar,idPostiAuto);
				assignmentParking.setId(id);
				listAssignmentParking.add(assignmentParking);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAssignmentParking;
		
	}
	
	public boolean insert(AssignmentParking assignmentParking) {
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, assignmentParking.getIdCar());
			preparedStatement.setInt(2, assignmentParking.getIdPostiAuto());
			
			preparedStatement.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Sono a catturare l'eccezione di insert in AssignmentParkingDAO");
			return false;
		}
		
	}
	
	public AssignmentParking read(int idAssignmentParking ) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, idAssignmentParking);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int idCar;
			int idPostiAuto;
			
			idCar = resultSet.getInt("id_car");
			idPostiAuto = resultSet.getInt("id_parkingplace");
			
			AssignmentParking assignmentParking = new AssignmentParking(idCar, idPostiAuto);
			assignmentParking.setId(resultSet.getInt("id"));
			
			return assignmentParking;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	public boolean update(AssignmentParking assignmentParkingToUpdate) {

		Connection connection = ConnectionSingleton.getInstance();
		
		//Check if id is present
		
		
		if(assignmentParkingToUpdate.getId() == 0) {
			System.out.println("Quest'assegnazione non risulta nel database");
			return false;
		}
		AssignmentParking assignmentParkingRead = read(assignmentParkingToUpdate.getId());
		try {
			if(!assignmentParkingRead.equals(assignmentParkingToUpdate)) {
				//fill the assignmetParkingToUpdate object
				
				if(assignmentParkingToUpdate.getIdCar() == 0) {
					assignmentParkingToUpdate.setId(assignmentParkingRead.getIdCar());
				}
				if(assignmentParkingToUpdate.getIdPostiAuto() == 0) {
					assignmentParkingToUpdate.setIdPostiAuto(assignmentParkingRead.getIdPostiAuto());
				}
				//update the assignmentParking
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, assignmentParkingToUpdate.getIdCar());
				preparedStatement.setInt(2, assignmentParkingToUpdate.getIdPostiAuto());
				preparedStatement.setInt(3, assignmentParkingToUpdate.getId());
				
				int a = preparedStatement.executeUpdate();
				if(a > 0) {
					return true;
				}else {
					return false;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Sono all'interno della classe AssignmentParkingDAO nel metodo update");
			return false;
		}
		return false;
	}
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int a = preparedStatement.executeUpdate();
			if(a > 0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
