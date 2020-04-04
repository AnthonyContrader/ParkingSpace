package it.contrader.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import it.contrader.model.Car;
import it.contrader.utils.ConnectionSingleton;

public class CarDAO implements DAO <Car>{
	
	private final String QUERY_ALL = "SELECT * FROM car";
	
	private final String QUERY_CREATE = "INSERT INTO car (model, license) VALUES (?,?)";
	private final String QUERY_READ = " SELECT * FROM car WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE car SET model=?, license=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM car WHERE id=?";
	
	public CarDAO () {
		
	}
	
	public List<Car> getAll(){
		List<Car> carList= new ArrayList<> ();
		System.out.println("sono dentro getAll");
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet= statement.executeQuery (QUERY_ALL);
			Car car;
			
			while (resultSet.next()) {
				
				int id = resultSet.getInt("id");
				System.out.println(id);
				String model = resultSet.getString("model");
				String license = resultSet.getString("license");
				car = new Car (id, model, license);
				
				carList.add(car);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carList;
	}
	
	public boolean insert (Car carToInsert) {
		
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, carToInsert.getModel());
			System.out.println("sono sull'eccezione 1");
			preparedStatement.setString(2, carToInsert.getLicense());
			System.out.println("sono sull'eccezione2");
			preparedStatement.execute();
			
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sono sull'eccezione");
			return false;
		}
	}
	
	public Car read (int carId) {
		
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement (QUERY_READ);
			
			preparedStatement.setInt(1, carId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String model, license;
			
			model = resultSet.getString("model");
			license = resultSet.getString("license");
			
			Car car = new Car (model, license);
			car.setId(resultSet.getInt("id"));
			
			return car;
		} catch (SQLException e) {
			System.out.println("read di DAO");
			return null;
		}
	}
	
	public boolean update (Car carToUpdate) {
		
		Connection connection = ConnectionSingleton.getInstance();
		
		// Controllo se c'è Id
		
		if (carToUpdate.getId()== 0)
			return false;				
		
		Car carRead = read(carToUpdate.getId());
		if (!carRead.equals(carToUpdate)) {
			
			try {
				
				if (carToUpdate.getModel()== null || carToUpdate.getModel().equals ("")) {
					carToUpdate.setModel(carRead.getModel());
				}
				
				if (carToUpdate.getLicense() == null || carToUpdate.getLicense().equals("")) {
					carToUpdate.setLicense(carRead.getLicense());
				}
				
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, carToUpdate.getModel());
				preparedStatement.setString(2, carToUpdate.getLicense());
				
				preparedStatement.setInt(3, carToUpdate.getId());
				
				int a = preparedStatement.executeUpdate();
				
				if (a>0)
					return true;
				
				else
					return false;
				
			}catch (SQLException e) {
				return false;
			}
			
		}
		
		return false;
		
	}
	
	public boolean delete (int id) {
		
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			
			if (n!=0)
				return true;
		}catch (SQLException e) {
			
		} 
		
		return false;
	}
	
}
