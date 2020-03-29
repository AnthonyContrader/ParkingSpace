package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.BillDTO;
import it.contrader.model.Bill;

/** 
 * @author comelli_laura
 */

/*Converting data_MODEL to data_DTO and also data_DTO in data_MODEL
 * such that I can take data from Model to Controller and View (to the user) converting them from ENTITY_type to DTO_type
 * and take data from Controller and View(from the user) to Model converting them from DTO_type to ENTITY_type
 */

public class BillConverter {
	
	/*Creating method toDTO that returns a BillDTO type object passing as argument a Bill type(Entity) object */
	public BillDTO toDTO(Bill bill) {	
		
		BillDTO billDTO = new BillDTO( bill.getId() , bill.getId_assignment() , bill.getPrice() , bill.getIs_paid());
		
		return billDTO;
	}
	
	/*Creating method toEntity that returns a Bill type(entity) object passing as argument a BillDTO type object */
	public Bill toEntity(BillDTO billDTO) {
		
		Bill bill_entity = new Bill(billDTO.getId() , billDTO.getId_assignment() , billDTO.getPrice() , billDTO.getIs_paid());
		
		return bill_entity;
	}
	
	
	/*Creating method toDTO for List that returns a BillDTO type list object passing as argument a Bill type(entity) list object*/
		/*I need this method to transfer Lists (e.c getAllList in DAO) from Model to DTO to let the users see that List on the View
		 * (Do not need the opposite method (from DTO to Model) because the user won't add Lists to DB)*/
	public List<BillDTO> toDTOList(List<Bill> billList){
		
		//creating an empty list with BillDTO type elements that I will fill with entity data converted and return
		List<BillDTO> BillDTOList = new ArrayList<>();
		
		for (Bill bills : billList) {
			
			BillDTOList.add(toDTO(bills));
		}
		
		return BillDTOList;
	}							
	
}