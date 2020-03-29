package it.contrader.service;

import java.util.List;

import it.contrader.converter.AssignmentParkingConverter;
import it.contrader.dao.AssignmentParkingDao;
import it.contrader.dto.AssignmentParkingDTO;

/**
 * 
 * @author Esat
 * 
 * */
public class AssignmentParkingService {
	private AssignmentParkingDao assignmentParkingDAO;
	private AssignmentParkingConverter assignmentParkingConverter;
	
	// Istanzio DAO  e Converter specifici.
	
	public AssignmentParkingService() {
		//invoca l'oggetto %_DAO%;
		this.assignmentParkingDAO       = new AssignmentParkingDao();
		this.assignmentParkingConverter = new AssignmentParkingConverter();
		
	}
	// Ottiene una lista di entità e le restituisce convertendole in DTO
	public List<AssignmentParkingDTO> getAll(){
		
		return this.assignmentParkingConverter.toDTOlist(assignmentParkingDAO.getAll());
	}
	// Ottiene un'entità e la restituisce convertendola in DTO
	public AssignmentParkingDTO read(int id) {
		
		return this.assignmentParkingConverter.toDTO(assignmentParkingDAO.read(id));
	}
	// Converte un DTO in entità e lo passa al DAO per l'inserimento
	public boolean insert(AssignmentParkingDTO apd) {
		return assignmentParkingDAO.insert(assignmentParkingConverter.toEntity(apd));
	}
	// Converte un AssignmentParkingDTO in entità e lo passa allo AssignmentParkingDAO per la modifica
	public boolean update(AssignmentParkingDTO apd) {
		return assignmentParkingDAO.update(assignmentParkingConverter.toEntity(apd));
	}
	//  Questo metodo chiama direttamente il DAO
	public boolean delete(int id) {
		return assignmentParkingDAO.delete(id);
	}
	
}
