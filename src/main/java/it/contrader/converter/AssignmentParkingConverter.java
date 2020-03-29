package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AssignmentParkingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.AssignmentParking;

/**
 * 
 * @author Esat
 * 
 * */
public class AssignmentParkingConverter {
	
	
	public AssignmentParkingDTO toDTO(AssignmentParking aParking) {
		AssignmentParkingDTO assignmentParkingDTO = new AssignmentParkingDTO(aParking.getId(), aParking.getIdCar(),aParking.getIdPostiAuto());
		return assignmentParkingDTO;
	}
	
	public AssignmentParking toEntity(AssignmentParkingDTO apd) {
		AssignmentParking aParking = new AssignmentParking(apd.getId(), apd.getIdCar(), apd.getIdPostiAuto());
		return aParking;
	}
	
	/**
	 * Metodo per convertire le liste di AssignmentParking
	 */
	public List<AssignmentParkingDTO> toDTOlist(List<AssignmentParking> assignmentParkingList){
		//Crea una lista vuota.
		List<AssignmentParkingDTO> userDTOList = new ArrayList<AssignmentParkingDTO>();
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(AssignmentParking ap: assignmentParkingList) {
			userDTOList.add(toDTO(ap));
			
		}
		return userDTOList;
	}
}
