package it.contrader.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Car;



/**
 * 
 * @author Maria Ilaria
 * 
 * Questo livello si occupa di recuperare le informazioni dal DB, il cui indirizzo è specificato nel file config.properties
 * 
 * I campi della classe DAO sono delle stringhe che rappresentano le QUERY da inoltrare al DB. 
 * Le QUERY verrano eseguite sul DB tramite la connessione istanziata con il pattern Singleton.
 * 
 */

public class CarDAO {
	
// Nessuna delle QUERY deve essere modificata, per questo motivo vengono dotate di modificatore "final"
	
	private final String QUERY_ALL = "SELECT * FROM car";
	private final String QUERY_CREATE = "INSERT INTO car (model, license) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM car WHERE ID=?";
	private final String QUERY_UPDATE = "UPDATE car SET model=? , license=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM car WHERE id=?";
	
// i metodi implementano le cose scritte tra le virgolette
	
// costruttore vuoto
	public CarDAO(){
	
	}
	
	/**
	 * 
	 *  
	 * gli array non possono cambiare la propria dim: il numero di elementi contenuti viene stabilito 
	 * al momento della crazione e rimane immutato. la classe ArrayList permette di rappresentare sequenze 
	 * di oggetti di lunghezza variabile. 
	 * ArrayList crea un verrore vuoto in cui la capacità iniziale non è soecificata (costruttore vuoto)
	 */
	
	public List<Car> getAll(){
		List<Car> carList = new ArrayList<>();
	
	    //la connessuone al DB viene istanziata seguendo il pattern Singleton, tramite il metodo getInstance.
		Connection connection = ConnectionSingleton.getInstance();
		
		/**Il costrutto try catch serve a gestire le eccezione e ad evitare che il programma fallisca nel caso in cui la query non andasse a buon fine.
		 * 
		 * try deve essere inserito il pezzo di codice che potrebbe generare un'eventuale eccezione
		 * 
		 * catch consente di definire un blocco di codice da eseguire, se si verifica un errore nel blocco try.
		 */
		
		try {
			
			Statement statement = connection.createStatement();
		
		// Le query SQL ritornano come risultato una tabella, rappresentate con java.sql.ResultSet
		
		// l'oggetto ResultSet verrà riempito dai dati ottenuti dalla query in seguito
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Car car;
		
		   // avanza alla riga successiva del ResultSet elemento; all’inizio ci si trova posizionati prima della prima colonna 
			
			while (resultSet.next()) {
			
			    // per la colonna indicata per indice, ritorna un int del valore
				int id = resultSet.getInt("id");
			
			    // per la colonna indicata per nome, ritorna una String del valore
				String model = resultSet.getString("model");
				String license = resultSet.getString("license");
			
			    // viene creata una nuova istanza dell'oggetto appartenente alla classe
				car = new Car (model, license);
				car.setId(id);
			
			    //metodo per aggiungere car nella lista
				carList.add(car);
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return carList;
	}
	
	// INSERT
	
	public boolean insert(Car carToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			// con il metodo preparedStatement impostiamo la query che vogliamo eseguire e gli evetuali parametri: model e license.
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, carToInsert.getModel());
			preparedStatement.setString(2, carToInsert.getLicense());
			
			// esegue uno statement che può ritornare risultati multipli
			preparedStatement.execute();
			return true;
		}
		catch (SQLException e) {
			return false;
		}
	}
	
	// READ
	
	public Car read(int carId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, carId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String model, license;

			model = resultSet.getString("model");
			license = resultSet.getString("license");
			
			Car car = new Car(model, license);
			car.setId(resultSet.getInt("id"));

			return car;
		}
		catch (SQLException e) {
			return null;
		}
		
	}
	
	// UPDATE
	
	public boolean update(Car carToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		// Controlla se id è presente
		if (carToUpdate.getId() == 0)
			return false;
		
		Car carRead = read (carToUpdate.getId());
		if (!carRead.equals(carToUpdate)) {
			try {
				
				// Riempie gli attributi
				if (carToUpdate.getModel () == null || carToUpdate.getModel().equals("") ) {
					carToUpdate.setModel(carRead.getModel());	
				}
				
				if (carToUpdate.getLicense() == null || carToUpdate.getLicense().equals ("")){
					carToUpdate.setLicense(carRead.getLicense());
					}
				
				
				// aggiorna car
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, carToUpdate.getModel());
				preparedStatement.setString(2, carToUpdate.getLicense());
				preparedStatement.setInt(3, carToUpdate.getId());
				
				int a = preparedStatement.executeUpdate(); //restituisce 0 o 1
				
				if (a > 0)
					return true;
				else 
					return false;
				
			}
			
			catch (SQLException e) {
				return false;
			}
		}
		
		return false;
				
	}
	
	// DELETE
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			
			int n = preparedStatement.executeUpdate();
			System.out.println(n);
			if (n!=0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}
	
	
	
	
		

