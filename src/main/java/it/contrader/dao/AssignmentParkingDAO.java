package it.contrader.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import it.contrader.model.AssignmentParking;
import it.contrader.utils.ConnectionSingleton;

public class AssignmentParkingDAO implements DAO<AssignmentParking> {
        private final String QUERY_ALL = "Select * from assignment_park";
        private final String QUERY_CREATE = "Insert into assignment_park(id_car, id_parkingplace, entryDate,entryTime) values (?,?,curdate(),now())";
        private final String QUERY_READ   = "Select * from assignment_park WHERE id=?";
        private final String QUERY_UPDATE = "UPDATE assignment_park SET id_car=?, id_parkingplace=? WHERE id=?";
        private final String QUERY_DELETE = "DELETE from assignment_park WHERE id=?";


        public AssignmentParkingDAO() {}

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
        			//System.out.println("id:" + id);
        			int idCar = resultSet.getInt("id_car");
        			int idPostiAuto = resultSet.getInt("id_parkingplace");
        			Date entryDate;
        			Time entryTime;
        			entryDate = resultSet.getDate("entryDate");
        			//System.out.println("\t\tDATE: " +entryDate.toLocalDate());
        			entryTime = resultSet.getTime("entryTime");
        			//System.out.println("\t\tTIME: " +entryTime.toLocalTime().minusHours(1));
        			assignmentParking = new AssignmentParking(idCar,idPostiAuto);
        			assignmentParking.setEntryDate(entryDate);
        			assignmentParking.setEntryTime(entryTime);
        			assignmentParking.setId(id);
        			//lista di oggetti assegnazione.
        			listAssignmentParking.add(assignmentParking);
        		}
        	} catch (SQLException e) {
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
                	//Insert current date & time
					/*
					 * java.util.Date date = new java.util.Date(); java.sql.Date sqlDate = new
					 * java.sql.Date(new java.util.Date().getTime()); java.sql.Timestamp sqlTime=new
					 * java.sql.Timestamp(date.getTime());
					 */
					
					//preparedStatement.setDate(3,sqlDate);
					//preparedStatement.setTimestamp(4,sqlTime);
					 
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
                	Date entryDate = resultSet.getDate("entryDate");
                	Time entryTime = resultSet.getTime("entryTime");
                	idCar = resultSet.getInt("id_car");
                	idPostiAuto = resultSet.getInt("id_parkingplace");

                	AssignmentParking assignmentParking = new AssignmentParking(idCar, idPostiAuto);
                	assignmentParking.setId(resultSet.getInt("id"));
                	assignmentParking.setEntryDate(entryDate);
                	assignmentParking.setEntryTime(entryTime);

                	return assignmentParking;
                } catch (SQLException e) {
                        e.printStackTrace();
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
    	if(!assignmentParkingRead.equals(assignmentParkingToUpdate)) {
    		try {

    			if(assignmentParkingToUpdate.getIdCar() == assignmentParkingRead.getIdCar() || assignmentParkingToUpdate.getIdCar() == 0){
    				assignmentParkingToUpdate.setIdCar(assignmentParkingRead.getIdCar()); }

    			if(assignmentParkingToUpdate.getIdPostiAuto() == assignmentParkingRead.getIdPostiAuto() ||assignmentParkingToUpdate.getIdPostiAuto()==0) {
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
    		}catch(SQLException e) {
    			e.printStackTrace();
    			System.out.println("Sono all'interno della classe AssignmentParkingDAO nel metodo update");
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
