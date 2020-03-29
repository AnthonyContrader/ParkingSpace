package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Parkingplace;
//operazioni di crud con database
public class ParkingplaceDAO {
	private final String QUERY_ALL = "SELECT * FROM parking_place";
	private final String QUERY_CREATE = "INSERT INTO parking_place (number_place) VALUES (?)";
	private final String QUERY_READ = "SELECT * FROM parking_place WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE parking_place SET number_place =? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM parking_place WHERE id=?";
// costrutto vuoto
	public ParkingplaceDAO() {
}
	// seleziona tutta la tabella parkingplace
	
	public List<Parkingplace> getAll(){ 
		// crea una nuovo array list
		
		List<Parkingplace> parkingplacesList = new ArrayList<>();
		// connessione al database con singleton
		Connection connection = ConnectionSingleton.getInstance();
		//costrutto try-catch è obbligatorio e serve a evitare che il programma fallisca nel caso in cui la query non andasse a buon fine
		try {
			//statement fornisce metodi per eseguire query con il db
			Statement statement = connection.createStatement();
			//ResultSet utilizzato per eseguire la query all
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Parkingplace parkingplace;
			// utilizzato per scorrere la riga
			while(resultSet.next()) {
				//incapsuliamo i valori con getInt
				int id = resultSet.getInt("id");
				int numberplace = resultSet.getInt("number_place");
				// creaiamo entità parkingplace con attributo numberplace
				parkingplace = new Parkingplace(numberplace);
				// inserisco id
				parkingplace.setId(id);
				// aggiungo parkingplace alla lista nuova
				parkingplacesList.add(parkingplace);
			}
			// nel caso di errore nella query entreremo nel catch
		} catch (SQLException e) { 
			// la traccia dello stack può essere stampata sull'errore standard ( traccia incapsulata = array di elementi)
			e.printStackTrace();
		}
		// senza errori ritorna la lista
		return parkingplacesList;
	}
	//la query viene eseguita all'interno di un metodo (insert)  attraverso una connessione al database istanziata tramite singleton
	public boolean insert(Parkingplace parkingplaceToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			//impostiamo la query che vogliamo eseguire
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			//impostiamo i parametri 
			preparedStatement.setInt(1, parkingplaceToInsert.getNumberplace());
			//esegue istruzione sql
			preparedStatement.execute();
			return true;
			// presenti errori nella query
		} catch (SQLException e) {
			return false;
	}
		
	}
	public Parkingplace read(int parkingplaceId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, parkingplaceId);
			//utilizzato per eseguire la query
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			// inizializzo la variabile numberplace
			int numberplace;
			// gli do un valore con get
			numberplace = resultSet.getInt("number_place");
			Parkingplace parkingplace = new Parkingplace(numberplace);
			parkingplace.setId(resultSet.getInt("id"));
			
			return parkingplace;
		} catch (SQLException e) {
			return null;
		}
	}
	public boolean update(Parkingplace parkingplaceToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		 // se la variabile id == 0 perchè non può essere nulla essendo int
		if (parkingplaceToUpdate.getId() == 0)
			return false;
		 
		Parkingplace parkingplaceRead = read(parkingplaceToUpdate.getId());
		// controllo degli attributi
		if (!parkingplaceRead.equals(parkingplaceToUpdate)) {
			try {
				if (parkingplaceToUpdate.getNumberplace() == 0) {
					parkingplaceToUpdate.setNumberplace(parkingplaceRead.getNumberplace());
				}
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, parkingplaceToUpdate.getNumberplace());
				preparedStatement.setInt(2, parkingplaceToUpdate.getId());
				int a = preparedStatement.executeUpdate();// restituisce 0 o 1 execute
				if(a > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
				
			}
		}
		return false;
		
	}
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
}
	
	
		
	
	
	
	
