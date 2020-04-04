package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Parkingplace;
import it.contrader.utils.ConnectionSingleton;

public  class ParkingplaceDAO implements DAO<Parkingplace>  {
	private final String QUERY_ALL = "SELECT * FROM parking_place ";
	private final String QUERY_CREATE = "INSERT INTO parking_place(number_place) VALUES(?)";
	private final String QUERY_READ = "SELECT * FROM parking_place WHERE id =?";
	private final String  QUERY_UPDATE = "UPDATE parking_place SET number_place=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM parking_place WHERE id=?";
	
	public ParkingplaceDAO() {
}

	@Override
	public List<Parkingplace> getAll() {
		List<Parkingplace> parkingplacesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Parkingplace parkingplace;
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int numberplace = resultSet.getInt("number_place");
				parkingplace = new Parkingplace(numberplace);
				parkingplace.setId(id);
				parkingplacesList.add(parkingplace);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return parkingplacesList;
	}

	@Override
	public Parkingplace read(int parkingplaceId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, parkingplaceId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int numberplace;
			numberplace = resultSet.getInt("number_place");
			Parkingplace parkingplace = new Parkingplace(numberplace);
			parkingplace.setId(resultSet.getInt("id"));
			return parkingplace;
		} catch (SQLException e) {
		return null;
	}
	}

	@Override
	public boolean insert(Parkingplace parkingplaceToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		    preparedStatement.setInt(1,parkingplaceToInsert.getNumberplace());
		    preparedStatement.execute();
		    return true;
		} catch(SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(Parkingplace parkingplaceToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if(parkingplaceToUpdate.getId() == 0)
		return false;
		Parkingplace parkingplaceRead = read(parkingplaceToUpdate.getId());
		if(!parkingplaceRead.equals(parkingplaceToUpdate)) {
			try {
				if(parkingplaceToUpdate.getNumberplace() == 0) {
				parkingplaceToUpdate.setNumberplace(parkingplaceRead.getNumberplace());
			}
			
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, parkingplaceToUpdate.getNumberplace());
			preparedStatement.setInt(2, parkingplaceToUpdate.getId());
			int a = preparedStatement.executeUpdate();
			if(a > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}
	
	return false;
}	
	

	@Override
	public boolean delete(int id) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
		preparedStatement.setInt(1, id);
		int n = preparedStatement.executeUpdate();
		if(n != 0)
			return true;
	} catch(SQLException e) {
	}
		return false;
	}
	
	
}
