package it.contrader.service;

/**
 * @author comelli_laura
*/

import java.util.List;

import it.contrader.converter.BillConverter;
import it.contrader.dao.BillDAO;
import it.contrader.dto.BillDTO;

/*Service calls and uses CONVERTER for the created object
 * Also calls DAO where we implemented the methods used to manipulate our Entity type objects
 * BUT we need these methods return DTO type object*/

public class BillService {
	
	private BillDAO billDAO;
	private BillConverter billCONVERTER;
	
	public BillService() {
		
		 //instantiated billDAO field as a BillDAO object
		this.billDAO = new BillDAO();  
		
		//instantiated billCONVERTER as a BillConverter object
		this.billCONVERTER = new BillConverter(); 
	}
	
	public List<BillDTO> getAllBill(){
		
		//to print the output to user , it must be DTO type, so I need to convert the results in DTO type
		return billCONVERTER.toDTOList(billDAO.getAllBill());
		
	}
	
	public boolean insert (BillDTO BillDTOInsert) {
		
		/*INSERT receives an input object from user(controller/view) as DTO type but our methods is programmed for receiving an Entity input object
		 * so I must convert the DTO input object in Entity */
		return billDAO.insert(billCONVERTER.toEntity(BillDTOInsert));
	}
	
	public BillDTO read(int id) {
		
		/*READ receives an integer int input and prints out the results that must be DTO type
		 * so I must convert the output in DTO*/
		return billCONVERTER.toDTO(billDAO.read(id));
	}
	
	public boolean update (BillDTO BillDTOUpdate) {
		
		/* UPDATE receives an input object from user(controller/view) as DTO type but our methods is programmed for receiving an Entity input object
		 * so I must convert the DTO input object in Entity */
		return billDAO.update(billCONVERTER.toEntity(BillDTOUpdate));
		
	}
	
	public boolean delete (int id) {
		
		/*DELETE receives an integer int input and print out a boolean--> directly connected to DAO*/
		return billDAO.delete(id);
		
	}
	
	
}